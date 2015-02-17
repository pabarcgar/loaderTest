package org.opencb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opencb.loaders.Loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by parce on 17/02/15.
 */
public class LoaderRunner<T> {

    private final Class<T> typeParameterClass;

    public LoaderRunner (Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void load(Path inputJsonFile, Loader<T> loader) {
        ObjectMapper jsonMapper = new ObjectMapper();

        try (Stream<String> lines = Files.lines(inputJsonFile)) {
            lines.map(jsonLine -> parseJsonLine(jsonLine, jsonMapper, typeParameterClass)).forEach(loader::load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadJava7Style(Path inputJsonFile, Loader<T> loader) {
        ObjectMapper jsonMapper = new ObjectMapper();
        try (BufferedReader br = new BufferedReader(new FileReader(inputJsonFile.toFile()))) {
            String jsonLine;
            while ((jsonLine = br.readLine()) != null) {
                T object = parseJsonLine(jsonLine, jsonMapper, typeParameterClass);
                loader.load(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public T parseJsonLine(String jsonLine, ObjectMapper jsonMapper, Class<T> jsonClass) {
        T object;
        try {
            object = jsonMapper.readValue(jsonLine, jsonClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return object;
    }
}
