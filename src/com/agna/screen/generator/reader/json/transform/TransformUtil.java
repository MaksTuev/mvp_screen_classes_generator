package com.agna.screen.generator.reader.json.transform;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class TransformUtil {

    public static <T, E extends Transformable<T>> T transform(@Nullable E object) {
        return object != null ? object.transform() : null;
    }

    public static <T, E extends Transformable<T>> ArrayList<T> transformCollection(Collection<E> src) {
        return CollectionUtils.mapEmptyIfNull(src, Transformable::transform);
    }
}