package com.framework.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


@Slf4j
public class FileUtil {

    public static String readFileAsString(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException ex) {
            log.error("Error reading file. " + ex);
            return null;
        }

    }


    public static byte[] readFileAsBytes(String path) {
        try {
            return Files.readAllBytes(Paths.get(path));
        } catch (IOException ex) {
            log.error("Error reading file. " + ex);
            return null;
        }

    }
    //http://www.quintic.com/software/sample_videos/Cricket%20Bowling%20-%20Footwork%20400fps.avi

    public static void downloadFile(){
        try {
            FileUtils.copyURLToFile(
                    new URL("https://www.sample-videos.com/video123/mp4/360/big_buck_bunny_360p_30mb.mp4"),
                    new File("src/test/resources/file_name2.avi"),
                    10000,
                    10000);
        }catch (IOException ex){
            log.error(ex.getMessage());
        }
    }


    public static File createFile(){
        File file = new File("src/test/resources/file-large.jpg");

        try {
            file.createNewFile();
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(1000009);
            raf.close();
        }catch (IOException ex){
            log.error(ex.getMessage());
        }

        return file;
    }


}