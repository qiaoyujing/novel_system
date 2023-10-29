package com.qj.novel.crawler.service.impl;

import com.qj.novel.crawler.entity.MainTestEntity;
import com.qj.novel.crawler.service.MainTestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MainTestServiceImpl implements MainTestService {
    private static final ThreadPoolExecutor threadPoolExcecutor = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1)
            , new BasicThreadFactory.Builder().namingPattern("mainTest-ThreadPool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    @Override
    public void dealWithMainTestEntity(MainTestEntity info) {
        log.info(""+info.getAge());
    }

    @Override
    public void dealWithMainTestEntity2(MainTestEntity info) {

    }
}
