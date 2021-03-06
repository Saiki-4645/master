package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = LogManager.getRootLogger();
        }
        return logger;
    }
}
