package study.tangpoo.livecodingtest.util.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final IpAccessInterceptor ipAccessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipAccessInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/static/**")
            .excludePathPatterns("/error/**");
//            .excludePathPatterns("/api/**");
    }
}
