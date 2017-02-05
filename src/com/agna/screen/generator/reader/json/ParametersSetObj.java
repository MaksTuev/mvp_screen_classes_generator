package com.agna.screen.generator.reader.json;

import com.agna.screen.generator.entity.ParametersSet;
import com.agna.screen.generator.reader.json.transform.TransformUtil;
import com.agna.screen.generator.reader.json.transform.Transformable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ParametersSetObj implements Transformable<ParametersSet>{
    @SerializedName("name")
    private String name;
    @SerializedName("parameters")
    private ArrayList<ParameterObj> parameters;

    @Override
    public ParametersSet transform() {
        return new ParametersSet(name, TransformUtil.transformCollection(parameters));
    }
}
