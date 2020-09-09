/**
 * @Project Name :  SchoolBus_Server
 * @Package Name :  com.orient.config.spring
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-04-16 9:20 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.config.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author :  panduanduan
 * @Description :  静态类方法中获取Spring中托管的相关对象信息
 * @Creation Date:  2018-04-16 9:20 PM
 */
@Component
@Lazy(false)
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}