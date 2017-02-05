package com.agna.screen.generator.reader.json;

import com.agna.screen.generator.entity.Config;
import com.agna.screen.generator.entity.GeneratorConfig;
import com.agna.screen.generator.entity.ParametersSet;
import com.agna.screen.generator.reader.json.transform.TransformUtil;
import com.agna.screen.generator.reader.json.transform.Transformable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class GeneratorConfigObj implements Transformable<GeneratorConfig>{
    @SerializedName("parametersSets")
    private List<ParametersSetObj> parametersSets;
    @SerializedName("cfg")
    private ArrayList<ConfigEntryObj> config;
    @SerializedName("globalParts")
    private ArrayList<PartObj> globalParts;

    @Override
    public GeneratorConfig transform() {
        return new GeneratorConfig(
                new Config(TransformUtil.transformCollection(config)),
                TransformUtil.transformCollection(parametersSets),
                TransformUtil.transformCollection(globalParts));
    }
}
