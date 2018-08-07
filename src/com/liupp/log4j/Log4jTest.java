package com.liupp.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
    private static Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/vinzor/javaCode/src/log4j.properties");
        for (int i = 0; i < 5000; i++) {

            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");

            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }
    }
}
