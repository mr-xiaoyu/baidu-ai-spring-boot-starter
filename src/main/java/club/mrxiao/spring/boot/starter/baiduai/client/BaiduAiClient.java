package club.mrxiao.spring.boot.starter.baiduai.client;

import com.baidu.aip.client.BaseClient;
import com.baidu.aip.contentcensor.EImgType;
import com.baidu.aip.http.AipRequest;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 百度Ai服务自定义
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-06-15
 */
public class BaiduAiClient extends BaseClient {

    public BaiduAiClient(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

    /**
     * 识别PDF电子发票
     * @param base64Content -base64编码后PDF文件
     * @param options - 可选参数对象，key: value都为string类型
     * @return JSONObject
     */
    public JSONObject discernPdfInvoice(String base64Content, HashMap<String, String> options) {
        AipRequest request = this.initAipRequest(options);
        request.addBody("pdf_file", base64Content);
        request.setUri("https://aip.baidubce.com/rest/2.0/ocr/v1/vat_invoice");
        postOperation(request);
        return requestServer(request);
    }

    /**
     * iOCR 财会版
     * @param content 数据（base64编码后PDF文件、base64编码后图片文件、文件url）
     * @param type 类型
     * @param options - 可选参数对象，key: value都为string类型
     * @return JSONObject
     */
    public JSONObject recogniseFinance(String content, EImgType type, HashMap<String, String> options){
        AipRequest request = this.buildIocrRequest(content,type,options);
        request.setUri("https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise/finance");
        postOperation(request);
        return requestServer(request);
    }

    /**
     * iOCR 通用版
     * @param content 数据（base64编码后PDF文件、base64编码后图片文件、文件url）
     * @param type 类型
     * @param options - 可选参数对象，key: value都为string类型
     * @return JSONObject
     */
    public JSONObject recognise(String content, EImgType type, HashMap<String, String> options){
        AipRequest request = this.buildIocrRequest(content,type,options);
        request.setUri("https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise");
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 构建 iOCR 请求参数
     * @param content 数据（base64编码后PDF文件、base64编码后图片文件、文件url）
     * @param type 类型
     * @param options - 可选参数对象，key: value都为string类型
     * @return AipRequest
     */
    private AipRequest buildIocrRequest(String content, EImgType type, HashMap<String, String> options){
        AipRequest request = this.initAipRequest(options);
        if (type == EImgType.PDF) {
            request.addBody("pdf_file", content);
        }else if(type == EImgType.FILE){
            request.addBody("image", content);
        }else if(type == EImgType.URL){
            request.addBody("url", content);
        }
        return request;
    }


    /**
     * 初始化
     * @param options  - 可选参数对象，key: value都为string类型
     * @return AipRequest
     */
    private AipRequest initAipRequest(HashMap<String, String> options){
        AipRequest request = new AipRequest();
        preOperation(request);
        if (options != null) {
            request.addBody(options);
        }
        return request;
    }
}
