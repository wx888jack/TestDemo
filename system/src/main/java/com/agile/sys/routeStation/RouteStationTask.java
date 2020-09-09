package com.agile.sys.routeStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时生成路线实例
 */
@Component
public class RouteStationTask {
    @Autowired
    ApplicationContext context;

    //03:00生成上学路线实例
    //13:00生成放学路线实例
//    @Scheduled(cron = "0 0 3,13 * * ? ")
//    @Scheduled(cron = "0/2 * * * * ?")
//    public void task() {
//        context.publishEvent(new RouteStationEvent(new Test("开始")));
//    }
}
