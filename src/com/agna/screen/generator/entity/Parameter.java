package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class Parameter {
    public static final String PARAMETER_TYPE = "parameterType";
    public static final String PARAMETER_NAME_LOWER_CASE = "parameterNameLowerCase";
    public static final String PARAMETER_NAME_CAPITALIZED = "parameterNameCapitalized";
    public static final String PARAMETER_POSITION = "parameterPosition";

    private String type;
    private String name;

    public Parameter(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public List<Part> generateParameterParts() {
        List<Part> parts = new ArrayList<>();
        parts.add(new Part(PARAMETER_TYPE, null, Arrays.asList(new PartValue(null, type))));
        parts.add(new Part(PARAMETER_NAME_LOWER_CASE, null, Arrays.asList(new PartValue(null, getLowerCaseName()))));
        parts.add(new Part(PARAMETER_NAME_CAPITALIZED, null, Arrays.asList(new PartValue(null, getCapitalizedName()))));
        return parts;
    }

    public Config generateParameterConfig(int position) {
        List<ConfigEntry> configEntries = new ArrayList<>();
        configEntries.add(new ConfigEntry(PARAMETER_TYPE, type));
        configEntries.add(new ConfigEntry(PARAMETER_POSITION, String.valueOf(position)));
        return new Config(configEntries);
    }

    private String getLowerCaseName() {
        char c = Character.toLowerCase(name.charAt(0));
        return c + name.substring(1);
    }

    private String getCapitalizedName() {
        char c = Character.toUpperCase(name.charAt(0));
        return c + name.substring(1);
    }

}
