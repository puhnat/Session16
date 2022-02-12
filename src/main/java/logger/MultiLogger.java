package logger;

import java.time.LocalDateTime;

public class MultiLogger {
    public static final int MAX_SIZE = 10;

    private volatile int count = 0;
    private volatile int number = 0;
    private volatile static Integer currentIndex = 0;

    private static volatile MultiLogger[] INSTANCE = new MultiLogger[MAX_SIZE];

    protected MultiLogger() {
        throw new IllegalStateException("Это мультитон!");
    }

    protected MultiLogger(int i) {
        number = i;
    }

    public static MultiLogger getInstance() {
        synchronized (currentIndex) {
            if (currentIndex >= 10) {
                currentIndex = currentIndex % MAX_SIZE;
            }
        }
        if (INSTANCE[currentIndex] == null) {
            synchronized (MultiLogger.class) {
                if (INSTANCE[currentIndex] == null) {
                    INSTANCE[currentIndex] = new MultiLogger(currentIndex);
                }
            }
        }
        return INSTANCE[currentIndex++];
    }

    public synchronized void log(String msg) {
        System.out.println("[" + number + "][" + count++ + "][" + LocalDateTime.now() + "] " + msg);
    }

}
