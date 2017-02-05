package com.agna.screen.generator.writer;

import com.agna.screen.generator.entity.ClassFile;

import java.io.*;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ClassWriter {

    public void write(List<ClassFile> classFiles){
        for(ClassFile classFile : classFiles){
            write(classFile);
        }
    }

    private void write(ClassFile classFile) {
        File file = new File(classFile.getPath() + "\\" + classFile.getName());
        file.getParentFile().mkdir();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "utf-8"))) {
            writer.write(classFile.getCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
