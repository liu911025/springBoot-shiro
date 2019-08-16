package com.example.demo.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "com.didispace.blog")
public class BlogProperties {


    private String name;

    private String title;
}
