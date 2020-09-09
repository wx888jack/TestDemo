package com.agile.sys.routeStation;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 路路线规则处理理器（ConstructRouteRuleHandlerListener）：根据当前时间，如果是03:00则获
 * 取所有上学路线，如果是13:00则获取所有放学路路线，将所有路线规则转化为路路线处理理器，并
 * 与路线定义相关联，存于事件变量量中
 */
@Component
public class ConstructRouteRuleHandlerListener implements SmartApplicationListener {
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
        System.out.println("ConstructRouteRuleHandlerListener:" + ((Test) applicationEvent.getSource()).getA());
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
