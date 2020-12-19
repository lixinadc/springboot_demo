package cn.tx.springboot.SrcConfig;

import cn.tx.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/header").setViewName("header");
        registry.addViewController("/add").setViewName("add");
        registry.addViewController("/toLogin").setViewName("login");
        //registry.addViewController("/main").setViewName("main");
        registry.addViewController("/menu").setViewName("menu");



    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> excludePathPatterns=new ArrayList<>();
        excludePathPatterns.add("/css/**");;
        excludePathPatterns.add("/images/**");;
        excludePathPatterns.add("/toLogin");;
        excludePathPatterns.add("/login");;
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**")
               .excludePathPatterns(excludePathPatterns);
    }

    //    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        List<String> excludePatterns = new ArrayList<String>();
//        excludePatterns.add("/css/**");
//        excludePatterns.add("/images/**");
//        excludePatterns.add("/toLogin");
//        excludePatterns.add("/login");
//
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(excludePatterns);
//
//    }
}
