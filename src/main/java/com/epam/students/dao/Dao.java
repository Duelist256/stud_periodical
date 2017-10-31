package com.epam.students.dao;

import java.util.List;

public interface Dao<T> {

    void create(T item);

    T read(String value);

    void update(T item);

    void delete(T item);

    List<T> getAll();
}
