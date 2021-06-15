package club.mrxiao.spring.boot.starter.baiduai.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类.
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-06-15
 */
@Data
@ConfigurationProperties(prefix = "xytool.ai.baidu")
public class BaiduAiProperties {
    /**
     * appId
     */
    private String appId;

    /**
     * appKey
     */
    private String appKey;

    /**
     * secretKey
     */
    private String secretKey;
}
