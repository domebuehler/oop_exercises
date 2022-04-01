package ch.hslu.oop.sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TemperaturFileReaderTest {

    private static final Logger LOG = LogManager.getLogger(TemperaturFileReaderTest.class);

    @Test
    public void testIfFileExists() {
        File file = new File("c:\\Code\\OOP\\testfiles\\export_01.csv");
        assertThat(file.exists()).isTrue();
    }

    @Test
    public void testFileReaderNumberOfItems() {
        List<String> list = new ArrayList<>();
        try {
            list = TemperaturFileReader.readTemperaturFile("c:\\Code\\OOP\\testfiles\\test.csv");
        } catch (FileNotFoundException exception) {
            LOG.error(exception);
        }
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    public void testFileReaderFirstItem() {
        List<String> list = new ArrayList<>();
        try {
            list = TemperaturFileReader.readTemperaturFile("c:\\Code\\OOP\\testfiles\\test.csv");
        } catch (FileNotFoundException e) {
            LOG.error(e);
        }
        assertThat(list.get(0)).isEqualTo("12.5;08:00");
    }

    @Test
    public void testFileReaderLastItem() {
        List<String> list = new ArrayList<>();
        try {
            list = TemperaturFileReader.readTemperaturFile("c:\\Code\\OOP\\testfiles\\test.csv");
        } catch (FileNotFoundException e) {
            LOG.error(e);
        }
        assertThat(list.get(4)).isEqualTo("20;12:00");
    }

    @Test
    public void testRemoveTemperatureEventListenerWithNull() {
        assertThatThrownBy(() -> {
            TemperaturFileReader.readTemperaturFile("xyz");
        }).
                isInstanceOf(FileNotFoundException.class);
    }

}