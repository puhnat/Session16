import logger.MultiLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MultiLoggerTest {

    @Test
    public void countArrayElements() {
        List<MultiLogger> testMultilogger = new ArrayList<>();

        // Заполнение массива
        for (int i = 0; i < MultiLogger.MAX_SIZE + 5; i++) {
            testMultilogger.add(MultiLogger.getInstance());
        }

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                MultiLogger ml = testMultilogger.get(0);
                ml.log("fdlfdlldfkldf");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                MultiLogger ml = testMultilogger.get(10);
                ml.log("sasdasda");
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                MultiLogger ml = testMultilogger.get(1);
                ml.log("f7565775fkldf");
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                MultiLogger ml = testMultilogger.get(11);
                ml.log("s423423da");
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        int expected = 15;
        int actual = testMultilogger.size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testLogMethod() {
        MultiLogger testMultiLogger = MultiLogger.getInstance();
        int hasError = 0;
        try {
            testMultiLogger.log("Привет");
        } catch (Exception e) {
            hasError = 1;
        }

        int expect = 0;
        int actual = hasError;

        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void testEmptyConstructor(){

        int hasError = 0;
        try {
            MultiLogger testMultiLogger = new MultiLogger();
        } catch (Exception e) {
            hasError = 1;
        }

        int expect = 1;
        int actual = hasError;

        Assertions.assertEquals(expect, actual);
    }

}
