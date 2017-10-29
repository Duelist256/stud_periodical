package com.epam.students.dao;

import java.util.List;

public interface Dao<Item> {
    void create(Item item);

    <T> Item read(T value);

    void update(Item item);

    void delete(Item item);

    List<Item> getAll();
}
