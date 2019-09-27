package com.framework.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Slf4j
public class FileUtils {

    public static String readFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException ex){
        log.error("Error reading file. " + ex);
        return null;
    }

}



}