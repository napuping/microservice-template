package com.nap.up.config;

import com.nap.up.common.handler.UserParameterResolve;
import com.nap.up.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @creator napuping
 * @createTime 2020/3/3
 * @description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //跨域
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //允许任何域名
        corsConfiguration.addAllowedHeader("*"); //允许任何头
        corsConfiguration.addAllowedMethod("*"); //允许任何方法
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); //注册
        return new CorsFilter(source);
    }

    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/css/**", "/js/**", "/img/**")
                .excludePathPatterns("/swagger-ui.html", "/swagger-resources/**", "/error", "/webjars/**");
    }
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    //配置参数解析器
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userParameterResolve());
    }
    @Bean
    public UserParameterResolve userParameterResolve() {
        return new UserParameterResolve();
    }
}
