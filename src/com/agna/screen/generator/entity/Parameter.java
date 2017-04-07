package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class Parameter {
    public static final String PARAMETER_TYPE = "parameterType";
    public static final String PARAMETER_TYPE_CAPITALIZED = "parameterTypeCapitalized";
    public static final String PARAMETER_NAME_LOWER_CASE = "parameterNameLowerCase";
    public static final String PARAMETER_NAME_CAPITALIZED = "parameterNameCapitalized";
    public static final String PARAMETER_POSITION = "parameterPosition";
    public static final String LAST_PARAMETER = "lastParameter";

    private String type;
    private String name;

    public Parameter(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public List<Part> generateParameterParts() {
        List<Part> parts = new ArrayList<>();
        parts.add(new Part(PARAMETER_TYPE, null, Arrays.asList(new PartValue(null, type))));
        parts.add(new Part(PARAMETER_TYPE_CAPITALIZED, null, Arrays.asList(new PartValue(null, getCapitalizedString(type)))));
        parts.add(new Part(PARAMETER_NAME_LOWER_CASE, null, Arrays.asList(new PartValue(null, getLowerCaseName()))));
        parts.add(new Part(PARAMETER_NAME_CAPITALIZED, null, Arrays.asList(new PartValue(null, getCapitalizedName()))));
        return parts;
    }

    public Config generateParameterConfig(int position, int size) {
        List<ConfigEntry> configEntries = new ArrayList<>();
        configEntries.add(new ConfigEntry(PARAMETER_TYPE, type));
        configEntries.add(new ConfigEntry(PARAMETER_POSITION, String.valueOf(position)));
        configEntries.add(new ConfigEntry(LAST_PARAMETER, position == size -1 ? "true": "false"));
        return new Config(configEntries);
    }

    private String getLowerCaseName() {
        char c = Character.toLowerCase(name.charAt(0));
        return c + name.substring(1);
    }

    private String getCapitalizedName() {
        return getCapitalizedString(name);
    }

    private String getCapitalizedString(String name) {
        char c = Character.toUpperCase(name.charAt(0));
        return c + name.substring(1);
    }

}
