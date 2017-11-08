package com.epam.students.dao;

import java.util.List;

/**
 * Generic interface for Data Access Objects.
 * Has basic CRUD methods and getAll() as long as it seems to be useful in this project.
 * Provided this interface is documented, I'm gonna allow myself not to document its implementations.
 *
 * @param <T> represents an object from database
 */

public interface Dao<T> {

    /**
     * Inserts new entry to database.
     *
     * @param item to insert into database.
     */
    void create(T item);

    /**
     * Takes an entry from database.
     *
     * @param id is passed to find required object.
     * @return T which is an object from specific table.
     */
    T read(int id);

    /**
     * Updates an entry in database.
     *
     * @param item to update.
     */
    void update(T item);

    /**
     * Deletes an entry from database.
     *
     * @param item to delete.
     */
    void delete(T item);

    /**
     * Presence of this method was arguable, but it proved itself useful in this project.
     *
     * @return list of all entries from specific table.
     */
    List<T> getAll();
}
