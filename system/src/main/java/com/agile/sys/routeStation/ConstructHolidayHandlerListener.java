package com.agile.sys.routeStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 调休处理器（ConstructHolidayHandlerListener）：获取所有调休映射表数据，转化为调休处理器，
 * 初步筛选出符合当前日期的调休处理器，存于事件变量中
 */
@Component
public class ConstructHolidayHandlerListener implements SmartApplicationListener {
    @Autowired
    ApplicationContext context;

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == RouteStationEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == Test.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        String s = ((Test) applicationEvent.getSource()).getA();
        System.out.println("ConstructHolidayHandlerListener:" + s);
        if ("开始".equals(s)) {
            ((Test) applicationEvent.getSource()).setA("继续");
        } else {
            //结束
        }

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
