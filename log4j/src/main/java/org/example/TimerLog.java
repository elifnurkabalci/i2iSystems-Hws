package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimerLog {
    private static final Logger logger = LogManager.getLogger(TimerLog.class);

    public static void main(String[] args) throws InterruptedException {
        int logInterval = 1000; // 1 saniye
        int minuteInterval = 60000; // 1 dakika
        int hourInterval = 3600000; // 1 saat

        while (true) {
            logDebugTime();
            logInfoTime();
            logErrorTime();

            Thread.sleep(logInterval);
        }
    }

    private static void logDebugTime() {
        logger.debug(getTimeInSeconds());
    }

    private static void logInfoTime() {
        logger.info(getTimeInMinutes());
    }

    private static void logErrorTime() {
        logger.error(getTimeInHours());
    }

    private static String getTimeInSeconds() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    private static String getTimeInMinutes() {
        return String.format("%02d:%02d:00", getHour(), getMinute());
    }

    private static String getTimeInHours() {
        return String.format("%02d:00:00", getHour());
    }

    private static int getHour() {
        return (int) (System.currentTimeMillis() % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000);
    }

    private static int getMinute() {
        return (int) (System.currentTimeMillis() % (60 * 60 * 1000)) / (60 * 1000);
    }

    private static int getSecond() {
        return (int) (System.currentTimeMillis() % (60 * 1000)) / 1000;
    }
}
