package com.agna.screen.generator.entity;

/**
 * Created by Maximus on 05.02.2017.
 */
public class PartValue {
    private Config config;

    private String value;

    public PartValue(Config config, String value) {
        this.config = config;
        this.value = value;
    }

    public Config getConfig() {
        return config;
    }

    public String getValue() {
        return value;
    }

}
