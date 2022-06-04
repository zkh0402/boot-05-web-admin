package com.zkh.admin.config;

/**
 * @author zkh
 * @date 2022/6/4 -15:34
 */

import com.zkh.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器应用步骤：
 * 1、编写一个实现拦截器实现HandlerInterceptor
 * 2、拦截器注册到容器中（实现WebMvcConfigurer接口的addInterceptors发明合法）
 * 3、指定拦截器规则【/**表示拦截所有,若拦截了所有，则静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**").        //    /**表示拦截所有，若拦截了所有，则静态资源也会被拦截
                excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
