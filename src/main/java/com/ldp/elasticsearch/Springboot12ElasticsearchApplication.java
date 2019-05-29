package com.ldp.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 有两种技术支持
 * springboot默认使用springdata elasticSearch模块进行操作
 * 还有一种就是jest（默认不生效）
 * <dependency>
 *     <groupId>io.searchbox</groupId>
 *     <artifactId>jest</artifactId>
 *     <version>5.3.4</version>
 * </dependency>
 *
 *
 */

@SpringBootApplication
public class Springboot12ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot12ElasticsearchApplication.class, args);
    }

}
