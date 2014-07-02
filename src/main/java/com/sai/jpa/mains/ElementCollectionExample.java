package com.sai.jpa.mains;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sai.jpa.entities.Student;

public class ElementCollectionExample {

	public static void main(String[] args) {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/company.odb");
		EntityManager em = emf.createEntityManager();
		// insertData(em);

		// Find the number of Point objects in the database:
		Query q1 = em.createQuery("SELECT COUNT(p) FROM Student p");
		System.out.println("Total Students: " + q1.getSingleResult());

		readData(em);
		// Close the database connection:
		em.close();
		emf.close();
	}

	private static void readData(EntityManager em) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Student> q = cb.createQuery(Student.class);
		final Root<Student> student = q.from(Student.class);
		q.select(student);
		q.where(cb.isMember("Telugu", student.<Set<String>> get("languages")));
		q.orderBy(cb.desc(student.get("created")));
		List<Student> students = em.createQuery(q).getResultList();
		for (Student s : students) {
			System.out.println(s.getName());
		}
	}

	private static void insertData(EntityManager em) {
		em.getTransaction().begin();
		Student student1 = new Student();
		student1.setName("Kulkarni");
		student1.setCreated(new Date());
		student1.setLanguages(new HashSet<String>(Arrays.asList("English", "Hindi")));

		Student student2 = new Student();
		student2.setName("Reddy");
		student2.setCreated(new Date());
		student2.setLanguages(new HashSet<String>(Arrays.asList("English", "Telugu")));

		em.persist(student1);
		em.persist(student2);
		em.getTransaction().commit();
	}
}
