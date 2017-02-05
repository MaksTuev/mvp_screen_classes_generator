package com.agna.screen.generator.entity;

import java.util.ArrayList;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ParametersSet {
    private String name;
    private ArrayList<Parameter> parameters;

    public ParametersSet(String name, ArrayList<Parameter> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }
}
