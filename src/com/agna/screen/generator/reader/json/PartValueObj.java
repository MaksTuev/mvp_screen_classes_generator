package com.agna.screen.generator.reader.json;

import com.agna.screen.generator.entity.*;
import com.agna.screen.generator.entity.Config;
import com.agna.screen.generator.reader.json.transform.TransformUtil;
import com.agna.screen.generator.reader.json.transform.Transformable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class PartValueObj implements Transformable<PartValue> {
    @SerializedName("cfg")
    private List<ConfigEntryObj> config = new ArrayList<>();
    @SerializedName("value")
    private String value;


    @Override
    public PartValue transform() {
        return new PartValue(
                new Config(TransformUtil.transformCollection(config)),
                value
        );
    }
}
