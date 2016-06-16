package org.trepel.spring.reproducer.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

/**
 * @author Tomas Repel</a>
 */
public abstract class HibernateRepository<T, I extends Serializable> implements Repository<T, I> {

    protected SessionFactory sessionFactory;

    Class<T> clazz;

    public HibernateRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public T findById(I id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public T save(T object) {
        T mergedInstance = (T) getCurrentSession().merge(object);
        // force a flush to refresh the id
        getCurrentSession().flush();
        return mergedInstance;
    }

    public void delete(T object) {
        getCurrentSession().delete(object);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getCurrentSession().createCriteria(clazz).list();
    }

    public long countAll() {
        return (Long) getCurrentSession().createCriteria(clazz).setProjection(Projections.count("id")).uniqueResult();
    }

}
