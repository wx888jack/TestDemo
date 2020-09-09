package com.agile.sys.routeStation;

import org.springframework.context.ApplicationEvent;

public class RouteStationEvent extends ApplicationEvent {
    private Test t;

    public RouteStationEvent(Test t) {
        super(t);
        this.t = t;
    }

    public Test getT() {
        return t;
    }

    public void setT(Test t) {
        this.t = t;
    }
}
