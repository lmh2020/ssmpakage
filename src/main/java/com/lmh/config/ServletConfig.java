package com.lmh.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //root加载web容器(跟配置)
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //父子容器
    //servlet加载 springMvc配置（对web请求的处理）
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    //拦截所有请求
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
