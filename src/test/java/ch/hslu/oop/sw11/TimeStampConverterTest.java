package ch.hslu.oop.sw11;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TimeStampConverterTest {

    @Test
    void testConvert() {
        LocalDateTime localDateTime = TimeStampConverter.convert("\"2018/03/28 23:24:42\"");

        String timestampAsString = "\"2018/03/28 23:24:42\"";
        LocalDateTime timestamp = LocalDateTime.parse(timestampAsString,
                DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));

        assertEquals(localDateTime, timestamp);
    }

    @Test
    void testConvertNotTheSame() {
        LocalDateTime localDateTime = TimeStampConverter.convert("\"2018/03/28 23:24:42\"");

        String timestampAsString = "\"2020/03/28 23:24:42\"";
        LocalDateTime timestamp = LocalDateTime.parse(timestampAsString,
                DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));

        assertNotEquals(localDateTime, timestamp);
    }
}