package com.sai.jpa.mains;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sai.jpa.entities.Department;
import com.sai.jpa.entities.Employee;

public class ObjectDB_OneToMany_Sample {

	public static void main(String[] args) {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/OneToMany.odb");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Department department1 = new Department();
		department1.setName("Q/A");

		Department department2 = new Department();
		department2.setName("HR");

		Employee employee1 = new Employee();
		employee1.setName("Jack");
		employee1.setSurname("Thomson");
		employee1.setTitle("QA Engineer");
		employee1.setCreated(new Date());
		employee1.setDepartment(department1);

		Employee employee2 = new Employee();
		employee2.setName("Mary");
		employee2.setSurname("Nickolson");
		employee2.setTitle("QA Engineer");
		employee2.setCreated(new Date());
		employee2.setDepartment(department2);

		em.persist(department1);
		em.persist(department2);
		em.persist(employee1);
		em.persist(employee2);

		em.getTransaction().commit();

		em.getTransaction().begin();
		long employeeId1 = employee1.getId();
		long employeeId2 = employee2.getId();


		Employee dbEmployee1 = em.find(Employee.class, employeeId1);
		System.out.println("dbEmployee " + dbEmployee1);

		Employee dbEmployee2 = em.find(Employee.class, employeeId2);
		System.out.println("dbEmployee " + dbEmployee2);

		Department dbDept1 = em.find(Department.class, department1.getId());

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
