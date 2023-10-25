package com.qj.novel.crawler.controller;

import com.qj.novel.crawler.service.MainTestService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/maintest")
@RestController
public class MainTestController {
    @Resource
    private MainTestService mainTestService;


    @GetMapping("/test1")
    @ApiOperation("测试1")
    public String getTest(@RequestParam String str) {
        log.info("str=" + str);
        return str + "sssdf";
    }

}
