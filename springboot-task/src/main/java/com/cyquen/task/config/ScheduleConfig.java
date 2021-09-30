package com.cyquen.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zheng
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer, AsyncConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler());
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10); // the number of thread in thread pool.
        taskScheduler.setThreadNamePrefix("springboot-task-scheduler-thread-"); // the prefix of thread name.
        taskScheduler.setAwaitTerminationSeconds(60); // the time which will wait before the thread pool shutdowns.
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true); // wait for all thread complete.
        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); // the policy of task discard.
        return taskScheduler;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(50);
        taskExecutor.setKeepAliveSeconds(15);
        taskExecutor.setThreadNamePrefix("springboot-task-executor-thread-");
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
