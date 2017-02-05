package com.agna.screen.generator.reader.json;

import com.agna.screen.generator.entity.*;
import com.agna.screen.generator.reader.json.transform.Transformable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ParameterObj implements Transformable<Parameter>{
    @SerializedName("type")
    private String type;
    @SerializedName("name")
    private String name;


    @Override
    public Parameter transform() {
        return new Parameter(type, name);
    }
}
