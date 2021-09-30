package com.cyquen.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zheng
 */
@Component
public class PrintTask {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void task1() {
        System.out.println(Thread.currentThread().getName() + " | " + dateFormat.format(new Date()));
    }

//    @Scheduled(cron = "0/2 * * * * ?")
//    public void task2() {
//        System.out.println(Thread.currentThread().getName() + " | " + dateFormat.format(new Date()));
//    }

    // Async use java ThreadPoolExecutor
    @Async
    @Scheduled(cron = "0/3 * * * * ?")
    public void task03() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " | task03 " + new Date().toLocaleString());
    }
}
