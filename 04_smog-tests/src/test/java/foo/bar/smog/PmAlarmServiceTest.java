package foo.bar.smog;

import foo.bar.fizzbuzz.FizzBuzz;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PmAlarmServiceTest {

    static PmAlarmService service;
    private static long timeExecution = 01;
    static long start =01;


    @BeforeAll
    static void classSetup() {
        service = new PmAlarmService();
        start =System.currentTimeMillis();
    }

    @AfterAll
    static void afterComplete() {
        long finish = System.currentTimeMillis();
        timeExecution=finish-start;
        Logger.getLogger("JUnit 5").info("Wszystkie testy trwaly " + timeExecution + "ms");

    }


    @Test
    void shouldReturnNoneForMeasurement_10() {
        assertEquals(AlarmLevel.NONE, service.getAlarmMessage(10, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_201() {

        assertEquals(AlarmLevel.INFO, service.getAlarmMessage(201, Country.POLAND));
    }

    @Test
    void shouldReturnInfoForMeasurement_350() {
        assertEquals(AlarmLevel.WARNING, service.getAlarmMessage(301, Country.POLAND));
    }

}
