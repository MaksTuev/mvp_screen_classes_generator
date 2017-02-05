package com.agna.screen.generator.reader.json;

import com.agna.screen.generator.entity.ConfigEntry;
import com.agna.screen.generator.reader.json.transform.Transformable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ConfigEntryObj implements Transformable<ConfigEntry> {
    @SerializedName("key")
    private String key;
    @SerializedName("value")
    private String value;


    @Override
    public ConfigEntry transform() {
        return new ConfigEntry(key, value);
    }
}
