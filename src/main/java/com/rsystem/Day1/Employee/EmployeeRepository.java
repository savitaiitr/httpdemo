package com.rsystem.Day1.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

@Repository
@Transactional
public class EmployeeRepository{ 
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Employee findById(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}

	public Employee update(Employee employee) {
		Employee emp = entityManager.merge(employee);
		return emp;
	}
	
	public Employee save(Employee employee) {
		Employee emp = entityManager.merge(employee);
		return emp;
	}

	public void deleteById(int id) {
		Employee emp = findById( id);
		entityManager.remove(emp);
	}

	public List<Employee> findAll() {
		TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("GET_EMPLOYEES_QUERY", Employee.class);
		
		return namedQuery.getResultList();
	}
	
}
