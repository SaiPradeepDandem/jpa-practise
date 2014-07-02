package com.sai.jpa.mains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sai.jpa.entities.Department;
import com.sai.jpa.entities.Employee;

public class FetchJoinTableChildEntities {

	public static void main(String[] args) {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/OneToMany.odb");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Deleting all the records in the table.
		System.out.println("Total Emps: " + em.createQuery("DELETE FROM Employee").executeUpdate());
		System.out.println("Total Depts: " + em.createQuery("DELETE FROM Department").executeUpdate());


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

		Employee employee3 = new Employee();
		employee3.setName("Sai");
		employee3.setSurname("Pradeep");
		employee3.setTitle("QA Engineer");
		employee3.setCreated(new Date());
		employee3.setDepartment(department1);

		em.persist(department1);
		em.persist(department2);
		em.persist(employee1);
		em.persist(employee2);
		em.persist(employee3);

		em.getTransaction().commit();

		em.getTransaction().begin();
		long employeeId1 = employee1.getId();
		long employeeId2 = employee2.getId();

		// Employee dbEmployee1 = em.find(Employee.class, employeeId1);
		// System.out.println("dbEmployee " + dbEmployee1);

		// Employee dbEmployee2 = em.find(Employee.class, employeeId2);
		// System.out.println("dbEmployee " + dbEmployee2.getDepartment().getEmployees());

		Department dbDept1 = em.find(Department.class, department1.getId());

		em.getTransaction().commit();

		em.close();
		emf.close();

		findDepartments(employeeId1);
	}

	private static void findDepartments(long employeeId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/OneToMany.odb");
		EntityManager em = emf.createEntityManager();
		List<Employee> ads = new ArrayList<>();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
		final Root<Employee> employee = q.from(Employee.class);
		q.select(employee);
		q.where(cb.equal(employee.<Long> get("id"), employeeId));
		List<Employee> emps = em.createQuery(q).getResultList();
		ads.addAll(emps);
		em.close();
		emf.close();

		for (Employee s : ads) {
			System.out.println(s.getDepartment());
		}
	}
}
