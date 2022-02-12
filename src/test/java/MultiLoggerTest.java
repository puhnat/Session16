import logger.MultiLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MultiLoggerTest {

    @Test
    public void countArrayElements(){
        List<MultiLogger> testMultilogger = new ArrayList<>();

        // Заполнение массива
        for (int i = 0; i < MultiLogger.MAX_SIZE + 5; i++) {
            testMultilogger.add(MultiLogger.getInstance());
        }

        int expected = 15;
        int actual = testMultilogger.size();

        Assertions.assertEquals(expected, actual);
    }

}
