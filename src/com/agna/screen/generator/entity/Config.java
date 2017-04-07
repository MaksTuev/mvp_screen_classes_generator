package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class Config {
    private List<ConfigEntry> entries = new ArrayList<ConfigEntry>();

    public Config(List<ConfigEntry> entries) {
        this.entries = entries;
    }

    public Config() {
    }

    public List<ConfigEntry> getEntries() {
        return entries;
    }

    public boolean correspondsTo(Config config) {
        return this.entries.stream()
                .map(configEntry -> config.getEntries().contains(configEntry))
                .reduce((prev, next)->prev && next)
                .orElseGet(() -> true);
    }

    public Config merge(Config config){
        List<ConfigEntry> newEntries = new ArrayList<ConfigEntry>();
        newEntries.addAll(entries);
        newEntries.addAll(config.getEntries());
        return new Config(newEntries);
    }
}
