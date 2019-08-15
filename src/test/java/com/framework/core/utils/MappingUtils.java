package com.framework.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MappingUtils {

    public static <T> T convertResponseToObject(final Class<T> clazz, final String response) throws IOException {
        return new ObjectMapper()
                .readerFor(clazz)
                .readValue(response);
    }
}