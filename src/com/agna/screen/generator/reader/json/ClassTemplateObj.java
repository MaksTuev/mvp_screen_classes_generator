package com.agna.screen.generator.reader.json;

import com.agna.screen.generator.entity.ClassTemplate;
import com.agna.screen.generator.reader.json.transform.TransformUtil;
import com.agna.screen.generator.reader.json.transform.Transformable;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ClassTemplateObj implements Transformable<ClassTemplate> {
    @SerializedName("packageName")
    private String packageName;
    @SerializedName("classNameTemplate")
    private String classNameTemplate;
    @SerializedName("codeTemplate")
    private String codeTemplate;
    @SerializedName("parts")
    private List<PartObj> partObjs = new ArrayList<PartObj>();


    @Override
    public ClassTemplate transform() {
        return new ClassTemplate(
                classNameTemplate,
                codeTemplate,
                TransformUtil.transformCollection(partObjs));
    }
}
