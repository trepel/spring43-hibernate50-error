package org.trepel.spring.reproducer.dao.hibernate;

import java.util.List;

/**
 * @author Tomas Repel</a>
 */
public interface Repository<T, I> {

    /**
     * Retrieves an object by its primary key
     *
     * @param id
     * @return
     */
    T findById(I id);

    /**
     * Saves an object to the database. Returns a persistent instance which may
     * be the object itself or another instance (depending whether a persistent
     * instance already exists in the Session/EntityManager)
     *
     * By and large, this has "merge" semantics
     *
     */
    T save(T object);

    void delete(T object);

    List<T> findAll();

    long countAll();
}
