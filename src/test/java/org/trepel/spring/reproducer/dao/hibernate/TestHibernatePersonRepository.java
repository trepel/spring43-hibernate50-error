package org.trepel.spring.reproducer.dao.hibernate;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;

/**
 * @author Tomas Repel
 */
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
      "classpath:test-hibernate-infrastructure.xml",
      "classpath:test-dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestHibernatePersonRepository
{
   @Autowired
   PersonRepository personRepository;

   @Test
   public void testPersonRepository()
   {
      long count = personRepository.countAll();
      Assert.assertEquals(3, count);
   }
}
