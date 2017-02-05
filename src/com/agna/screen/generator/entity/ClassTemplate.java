package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ClassTemplate {
    private String classNameTemplate;
    private String codeTemplate;
    private List<Part> parts = new ArrayList<Part>();

    public ClassTemplate(String classNameTemplate, String codeTemplate, List<Part> parts) {
        this.classNameTemplate = classNameTemplate;
        this.codeTemplate = codeTemplate;
        this.parts = parts;
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
}
