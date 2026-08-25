package com.joinin.mvc.configuration;

import feign.codec.Encoder;
import feign.form.MultipartFormContentProcessor;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.openfeign.support.FeignHttpMessageConverters;
import org.springframework.cloud.openfeign.support.JsonFormWriter;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static feign.form.ContentType.MULTIPART;

@Configuration
public class FeignMultipartConfig {

    @Bean
    public JsonFormWriter jsonFormWriter() {
        return new JsonFormWriter();
    }

    @Bean
    public Encoder feignFormEncoder(ObjectProvider<FeignHttpMessageConverters> messageConverters,
                                    JsonFormWriter jsonFormWriter) {
        SpringFormEncoder encoder = new SpringFormEncoder(new SpringEncoder(messageConverters));
        MultipartFormContentProcessor processor = (MultipartFormContentProcessor) encoder.getContentProcessor(MULTIPART);
        processor.addFirstWriter(jsonFormWriter);
        return encoder;
    }
}