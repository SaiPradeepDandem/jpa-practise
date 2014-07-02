package com.sai.jpa.datagenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;



import com.sai.jpa.entities.Locality;
import com.sai.jpa.entities.Person;
import com.sai.jpa.entities.Student;

public class DataGenerator {

	public static void insertStudentData(EntityManager em) {
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

	public static void insertPersonData(EntityManager em) {
		em.getTransaction().begin();
		Person person1 = new Person("Raja", buildDate("15/02/1990"));
		Person person2 = new Person("Sunny", buildDate("17/07/1992"));
		Person person3 = new Person("Dada", buildDate("11/01/1988"));

		em.persist(person1);
		em.persist(person2);
		em.persist(person3);
		em.getTransaction().commit();
	}

	private static final Pattern NORMAL_DATE_PATTERN = Pattern
			.compile("^(0[1-9]|[12][0-9]|3[01])[/ /.](0[1-9]|1[012])[/ /.](19|20)\\d\\d$");

	public static Date buildDate(String criteria) {
		final Matcher dateMatcher = NORMAL_DATE_PATTERN.matcher(criteria);
		try {
			if (dateMatcher.matches()) {
				return new SimpleDateFormat("dd/MM/yyyy").parse(criteria);
			} else {
				return null;
			}
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static List<Locality> getLocalities(){
		return Arrays.asList(new Locality("Kothrud","EP"),
				new Locality("Kondwa","WP"),
				new Locality("PaudRoad","EP"),
				new Locality("Sinhagad","EP"),
				new Locality("Kothrud","EP"),
				new Locality("FatimaNagar","WP"),
				new Locality("Aundh","NP"),
				new Locality("BalajiNagar","SP"),
				new Locality("Kondwa","WP"),
				new Locality("Bavdan","EP"));
	}
}
