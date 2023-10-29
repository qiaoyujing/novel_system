package com.qj.novel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
@EnableAsync
@EnableScheduling
public class NovelCrawlerApplication {
    public static void main(String[] args){
        SpringApplication.run(NovelCrawlerApplication.class);
    }

}
