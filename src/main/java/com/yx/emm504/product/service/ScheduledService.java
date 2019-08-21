package com.yx.emm504.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Async
public class ScheduledService {
    @Scheduled(cron = "0 35 13 * * ?")
    public void scheduled(){
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());

    }
}
