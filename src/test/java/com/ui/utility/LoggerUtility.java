package com.ui.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static Logger logger;

    private LoggerUtility() {
    }

    public static Logger getLogger(Class<?> clazz){
        if(logger==null) { // when first time when we are creating an object then only the object will be created i.e. if the logger is null then onlt the object will be initialised else the same refernce will be called again
            logger = LogManager.getLogger(clazz);
        }
        return logger;
    }
}
