package com.agna.screen.generator.entity;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class GeneratorConfig {
    private Config config;
    private List<ParametersSet> parametersSets;
    private List<Part> globalParts;

    public GeneratorConfig(Config config, List<ParametersSet> parametersSets, List<Part> globalParts) {
        this.config = config;
        this.parametersSets = parametersSets;
        this.globalParts = globalParts;
    }

    public Config getConfig() {
        return config;
    }

    public List<Part> getGlobalParts() {
        return globalParts;
    }


    public List<ParametersSet> getParametersSets() {
        return parametersSets;
    }

    public GeneratorConfig merge(GeneratorConfig screenGeneratorConfig) {
        return new GeneratorConfig(
                config.merge(screenGeneratorConfig.getConfig()),
                ParameterSetsUtil.merge(parametersSets, screenGeneratorConfig.getParametersSets()),
                PartListUtil.mergeParts(globalParts, screenGeneratorConfig.getGlobalParts()));

    }
}
