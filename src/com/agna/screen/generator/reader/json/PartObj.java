package com.agna.screen.generator.reader.json;

import com.agna.screen.generator.entity.Part;
import com.agna.screen.generator.reader.json.transform.TransformUtil;
import com.agna.screen.generator.reader.json.transform.Transformable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class PartObj implements Transformable<Part> {
    @SerializedName("name")
    private String name;
    @SerializedName("parametersSetName")
    private String parametersSetName;
    @SerializedName("values")
    private List<PartValueObj> values = new ArrayList<PartValueObj>();


    @Override
    public Part transform() {
        return new Part(name, parametersSetName, TransformUtil.transformCollection(values));
    }
}
