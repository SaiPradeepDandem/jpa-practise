package com.sai.jpa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy = "department"/* , fetch = FetchType.EAGER */)
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String deptName) {
		this.name = deptName;
	}

	public void addEmployee(Employee employee) {
		if (!employees.contains(employee)) {
			employees.add(employee);

		}
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return "Department [employees=" + employees + ", id=" + id + ", name=" + name + "]";
	}
}