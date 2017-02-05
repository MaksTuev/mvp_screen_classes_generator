package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class Part {
    private String name;
    private String parametersSetName;
    private List<PartValue> values = new ArrayList<PartValue>();

    public Part(String name, String parametersSetName, List<PartValue> values) {
        this.name = name;
        this.parametersSetName = parametersSetName;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public List<PartValue> getValues() {
        return values;
    }

    public String getParametersSetName() {
        return parametersSetName;
    }

    public boolean isDependendsOnParameters() {
        return parametersSetName != null;
    }

    public String getSuitablePartValue(Config contextConfig) {
        String value = "";
        for (PartValue partValue : getValues()) {
            if (partValue.getConfig() == null) {
                value = partValue.getValue();
                continue;
            }
            if (partValue.getConfig().correspondsTo(contextConfig)) {
                value = partValue.getValue();
                break;
            }
        }
        return value;
    }
}
