package com.agna.screen.generator.reader.json.transform;

/**
 * Интерфейс, указывающий что объект может быть трансформирован в объект типа T
 *
 * @param <T>
 */
public interface Transformable<T> {
    T transform();
}