package club.mrxiao.spring.boot.starter.baiduai.api.impl;

import club.mrxiao.spring.boot.starter.baiduai.api.BaiduAiService;
import club.mrxiao.spring.boot.starter.baiduai.client.BaiduAiClient;
import club.mrxiao.spring.boot.starter.baiduai.properties.BaiduAiProperties;
import com.baidu.aip.contentcensor.EImgType;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 百度Ai服务接口实现
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-06-15
 */
public class BaiduAiServiceImpl implements BaiduAiService {

    private BaiduAiProperties baiduAiProperties;
    private AipOcr aipOcr;
    private BaiduAiClient client;

    @Override
    public void setConfig(BaiduAiProperties properties) {
        this.baiduAiProperties = properties;
        this.aipOcr = new AipOcr(properties.getAppId(),properties.getAppKey(),properties.getSecretKey());
        this.client = new BaiduAiClient(properties.getAppId(),properties.getAppKey(),properties.getSecretKey());
    }

    @Override
    public BaiduAiProperties getConfig() {
        return this.baiduAiProperties;
    }

    @Override
    public AipOcr getAipOcr() {
        return this.aipOcr;
    }

    @Override
    public JSONObject discernPdfInvoice(String base64Content, HashMap<String, String> options) {
        return client.discernPdfInvoice(base64Content,options);
    }

    @Override
    public JSONObject recogniseFinance(String content, EImgType type, HashMap<String, String> options) {
        return client.recogniseFinance(content,type,options);
    }

    @Override
    public JSONObject recognise(String content, EImgType type, HashMap<String, String> options) {
        return client.recognise(content,type,options);
    }
}
