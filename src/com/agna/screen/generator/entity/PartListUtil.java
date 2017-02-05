package com.agna.screen.generator.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class PartListUtil {

    /**
     * //todo remove same
     */
    public static List<Part> mergeParts(List<Part> first, List<Part> second){
        List<Part> result = new ArrayList<>();
        result.addAll(first);
        result.addAll(second);
        return result;
    }
}
