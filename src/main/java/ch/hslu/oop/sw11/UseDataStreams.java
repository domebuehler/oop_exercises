package ch.hslu.oop.sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public final class UseDataStreams {

    private static final Logger LOG = LogManager.getLogger(UseDataStreams.class);

    //besser .dat oder .bin - dann ist klar, dass es keine Text-Datei ist!
    private File file = new File("c:\\Code\\OOP\\testfiles\\datastream.dat");

    public void writeIntInFile(int value) {
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(value);
        } catch (FileNotFoundException exception) {
            LOG.error("file was not found", exception);
        } catch (IOException exception) {
            LOG.error("error while writing", exception);
        }
    }

    public void writeSomeTypes(int integer, char character, float floatvalue) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(integer);
            dos.writeChar(character);
            dos.writeFloat(floatvalue);
        } catch (FileNotFoundException exception) {
            LOG.error("file was not found", exception);
        } catch (IOException exception) {
            LOG.error("error while writing");
        }
    }

    public void writeStringInFile(String string) {
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(file))) {
            dos.writeChars(string);
        } catch (FileNotFoundException exception) {
            LOG.error("file was not found", exception);
        } catch (IOException exception) {
            LOG.error("error while writing", exception);
        }
    }

    public void printDataStream() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            LOG.info(dis.readInt());
        } catch (FileNotFoundException exception) {
            LOG.error("file was not found", exception);
        } catch (IOException exception) {
            LOG.error("error while reading", exception);
        }
    }

    public void printReadSomeTypes() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            LOG.info(dis.readInt());
            LOG.info(dis.readChar());
            LOG.info(dis.readFloat());
        } catch (FileNotFoundException exception) {
            LOG.error("file was not found", exception);
        } catch (IOException exception) {
            LOG.error("error while reading", exception);
        }
    }
}
