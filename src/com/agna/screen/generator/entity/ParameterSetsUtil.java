package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class ParameterSetsUtil {

    //todo remove same
    public static List<ParametersSet> merge(List<ParametersSet> first, List<ParametersSet> second){
        List<ParametersSet> result = new ArrayList<>();
        result.addAll(first);
        result.addAll(second);
        return result;
    }
}
