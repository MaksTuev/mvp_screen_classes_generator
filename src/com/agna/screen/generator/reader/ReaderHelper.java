package com.agna.screen.generator.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ReaderHelper {

    public static String readFile(String path){
        System.out.printf("start read file: \n"+ path +"\n");
        return readFile(new File(path));
    }

    public static String readFile(File file){
        try (Scanner scanner = new Scanner(file)){
            return scanner.useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
