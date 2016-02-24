package service;

import org.apache.log4j.Logger;

public class Log {
    private static Logger logger = Logger.getLogger(Log.class.getName());

    public static void  info(String s){
        logger.info(s);
    }
}