package com.agna.screen.generator.entity;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ClassFile {
    private String name;
    private String path;
    private String code;

    public ClassFile(String name, String path, String code) {
        this.name = name;
        this.path = path;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getCode() {
        return code;
    }
}
