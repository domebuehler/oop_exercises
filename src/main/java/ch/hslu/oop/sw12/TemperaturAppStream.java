package ch.hslu.oop.sw12;

import ch.hslu.oop.sw11.Temperatur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public final class TemperaturAppStream {

    private static final Logger LOG = LogManager.getLogger(TemperaturAppStream.class);
    private File file = new File("c:\\Code\\OOP\\testfiles\\temperatures.dat");

    public void writeInFile(TemperaturVerlauf temperaturVerlauf) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            writeContentInFile(dos, temperaturVerlauf);
        } catch (FileNotFoundException exception) {
            LOG.error("file was not found", exception);
        } catch (IOException exception) {
            LOG.error("error while writing", exception);
        }
    }

    private void writeContentInFile(DataOutputStream dos,
                                    TemperaturVerlauf temperaturVerlauf) throws IOException {
        int count = temperaturVerlauf.getCount();
        dos.writeInt(count);
        for (int i = 0; i < count; i++) {
            dos.writeFloat(temperaturVerlauf.getTemperatur(i).getTempCelsius());
        }
    }

    public void readFile() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            readContentInFile(dis);
        } catch (FileNotFoundException exception) {
            LOG.error("file was not found", exception);
        } catch (IOException exception) {
            LOG.error("error while reading");
        }
    }

    private void readContentInFile(DataInputStream dis) throws IOException {
        int count = dis.readInt();
        LOG.info("number of temperatures in file: {}", count);
        for (int i = 0; i < count; i++) {
            float value = dis.readFloat();
            LOG.info("item number {} = " + Temperatur.createFromCelsius(value), i);
        }
    }
}
