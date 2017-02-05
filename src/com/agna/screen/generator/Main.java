package com.agna.screen.generator;

import com.agna.screen.generator.entity.ClassFile;
import com.agna.screen.generator.entity.FullConfiguration;
import com.agna.screen.generator.generator.Generator;
import com.agna.screen.generator.reader.FullConfigurationReader;
import com.agna.screen.generator.writer.ClassWriter;
import com.google.gson.Gson;

import java.io.Console;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            FullConfigurationReader fullConfigurationReader = new FullConfigurationReader();
            FullConfiguration fullConfiguration = fullConfigurationReader.read();
            Generator generator = new Generator();
            List<ClassFile> classFiles = generator.generate(fullConfiguration);
            ClassWriter classWriter = new ClassWriter();
            classWriter.write(classFiles);
        } catch (Exception e){
            e.printStackTrace();
            System.console().readLine();
        }
    }
}
