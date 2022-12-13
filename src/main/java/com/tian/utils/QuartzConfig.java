package com.tian.utils;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年12月11日 21:48
 */
@Configuration
public class QuartzConfig {

   /* @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(MyQuartz.class).withIdentity("myQuartz").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()

                .withIntervalInSeconds(10)  //设置时间周期单位秒
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())

                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }*/
}
