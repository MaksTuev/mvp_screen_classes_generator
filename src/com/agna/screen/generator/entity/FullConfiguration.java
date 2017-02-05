package com.agna.screen.generator.entity;

import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class FullConfiguration {
    private GeneratorConfig generatorConfig;
    private List<ClassTemplate> classTemplates;

    public FullConfiguration(GeneratorConfig generatorConfig, List<ClassTemplate> classTemplates) {
        this.generatorConfig = generatorConfig;
        this.classTemplates = classTemplates;
    }

    public GeneratorConfig getGeneratorConfig() {
        return generatorConfig;
    }

    public List<ClassTemplate> getClassTemplates() {
        return classTemplates;
    }
}
