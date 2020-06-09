//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.wiulus.spring.cloud.logs.logging;

import org.slf4j.LoggerFactory;

public class MonitorLoggerFactory {
    public MonitorLoggerFactory() {
    }

    public static MonitorLogger getMonitorLogger(Class<?> clazz) {
        return new MonitorLogger(LoggerFactory.getLogger(clazz));
    }

    public static MonitorLogger getMonitorLogger(String name) {
        return new MonitorLogger(LoggerFactory.getLogger(name));
    }
}
