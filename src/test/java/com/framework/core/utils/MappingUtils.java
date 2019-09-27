package com.framework.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MappingUtils {

    public static <T> T convertResponseToObject(final Class<T> clazz, final String response) {
        try{
            return new ObjectMapper()
                    .readerFor(clazz)
                    .readValue(response);
        } catch (IOException ex){
            log.error(ex.getMessage());
            return null;
        }
    }
}