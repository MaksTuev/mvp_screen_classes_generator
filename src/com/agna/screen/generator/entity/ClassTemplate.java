package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ClassTemplate {
    private String classNameTemplate;
    private String codeTemplate;
    private List<Part> parts = new ArrayList<Part>();
    private Config config = new Config();

    public ClassTemplate(String classNameTemplate, String codeTemplate, List<Part> parts, Config config) {
        this.classNameTemplate = classNameTemplate;
        this.codeTemplate = codeTemplate;
        this.parts = parts;
        this.config = config;
    }

    public String getClassNameTemplate() {
        return classNameTemplate;
    }

    public String getCodeTemplate() {
        return codeTemplate;
    }

    public List<Part> getParts() {
        return parts;
    }

    public Config getConfig() {
        return config;
    }
}
