package club.mrxiao.spring.boot.starter.baiduai.config;

import club.mrxiao.spring.boot.starter.baiduai.api.BaiduAiService;
import club.mrxiao.spring.boot.starter.baiduai.api.impl.BaiduAiServiceImpl;
import club.mrxiao.spring.boot.starter.baiduai.properties.BaiduAiProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置.
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-06-15
 */
@Configuration
@AllArgsConstructor
@ConditionalOnClass(BaiduAiService.class)
@EnableConfigurationProperties(BaiduAiProperties.class)
@ConditionalOnProperty(prefix = "xytool.ai.baidu", name = "enabled", matchIfMissing = true)
public class BaiduAiAutoConfiguration {

    private final BaiduAiProperties baiduAiProperties;

    @Bean
    @ConditionalOnMissingBean(BaiduAiService.class)
    public BaiduAiService baiduAiService() {
        final BaiduAiService service = new BaiduAiServiceImpl();
        service.setConfig(this.baiduAiProperties);
        return service;
    }
}
