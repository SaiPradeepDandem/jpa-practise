package com.sai.jpa.mains;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sai.jpa.datagenerator.DataGenerator;
import com.sai.jpa.entities.Person;

public class QueryByDateRangeExample {
	public static void main(String[] args) {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
		EntityManager em = emf.createEntityManager();
		// DataGenerator.insertPersonData(em);

		// Find the number of Point objects in the database:
		Query q1 = em.createQuery("SELECT COUNT(p) FROM Person p");
		System.out.println("Total Persons: " + q1.getSingleResult());

		findByDateRange(em);
		// Close the database connection:
		em.close();
		emf.close();
	}

	private static void findByDateRange(EntityManager em) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Person> q = cb.createQuery(Person.class);
		final Root<Person> person = q.from(Person.class);
		q.select(person);
		q.where(cb.and(cb.greaterThan(person.<Date> get("birthDate"), DataGenerator.buildDate("15/04/1989")),
				cb.lessThan(person.<Date> get("birthDate"), DataGenerator.buildDate("15/04/1997"))));
		List<Person> persons = em.createQuery(q).getResultList();
		for (Person s : persons) {
			System.out.println(s.getName() + " - " + s.getBirthDate());
		}
	}
}
