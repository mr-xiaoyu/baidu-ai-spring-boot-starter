package club.mrxiao.spring.boot.starter.baiduai.api;

import club.mrxiao.spring.boot.starter.baiduai.properties.BaiduAiProperties;
import com.baidu.aip.contentcensor.EImgType;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 百度Ai服务接口
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-06-15
 */
public interface BaiduAiService {

    /**
     * 设置配置
     * @param properties {@link BaiduAiProperties}
     */
    void setConfig(BaiduAiProperties properties);

    /**
     * 获取配置
     * @return {@link BaiduAiProperties}
     */
    BaiduAiProperties getConfig();

    /**
     * 获取ocr客户端
     * @return {@link AipOcr}
     */
    AipOcr getAipOcr();

    /**
     * 识别PDF电子发票
     * @param base64Content -base64编码后PDF文件
     * @param options - 可选参数对象，key: value都为string类型
     * @return JSONObject
     */
    JSONObject discernPdfInvoice(String base64Content, HashMap<String, String> options);


    /**
     * iOCR 财会版
     * @param content 数据（base64编码后PDF文件、base64编码后图片文件、文件url）
     * @param type 类型
     * @param options - 可选参数对象，key: value都为string类型
     * @return JSONObject
     */
    JSONObject recogniseFinance(String content, EImgType type, HashMap<String, String> options);


    /**
     * iOCR 通用版
     * @param content 数据（base64编码后PDF文件、base64编码后图片文件、文件url）
     * @param type 类型
     * @param options - 可选参数对象，key: value都为string类型
     * @return JSONObject
     */
    JSONObject recognise(String content, EImgType type, HashMap<String, String> options);
}
