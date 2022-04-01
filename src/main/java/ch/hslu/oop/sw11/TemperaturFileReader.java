package ch.hslu.oop.sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class TemperaturFileReader {
    private static final Logger LOG = LogManager.getLogger(TemperaturFileReader.class);

    public static List<String> readTemperaturFile(final String fileString) throws FileNotFoundException {
        File file = new File(fileString);
        List<String> list = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader br =
                         new BufferedReader(new InputStreamReader(
                                 new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                while ((line = br.readLine()) != null) {
                    LOG.info(line);
                    if (line != null) {
                        list.add(line.replace("﻿", ""));
                    }
                }
            } catch (IOException exception) {
                LOG.error("error while reading", exception);
            }
        } else {
            throw new FileNotFoundException();
        }
        return list;
    }
}
