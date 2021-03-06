package com.example.demo.webConfig;

import com.example.demo.webConfig.interceptor.DemoRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class DemoWebMVCConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private DemoRequestInterceptor demoInterceptor ;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(demoInterceptor);
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){

        super.configureMessageConverters(converters);
        converters.add(0, mappingJackson2HttpMessageConverter);
    }


}
