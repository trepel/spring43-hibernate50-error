package org.trepel.spring.reproducer.dao.hibernate;

import org.springframework.stereotype.Component;

/**
 * @author Tomas Repel
 */
@Component
public class HibernatePersonRepository extends HibernateRepository<Person, Long> implements PersonRepository {

    public HibernatePersonRepository() {
        super(Person.class);
    }

}
