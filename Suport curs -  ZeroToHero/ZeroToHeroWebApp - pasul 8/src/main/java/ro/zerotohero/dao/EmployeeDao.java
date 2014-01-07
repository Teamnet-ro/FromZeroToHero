package ro.zerotohero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.model.Employee;
@Repository  
public class EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		return employeeList;
	}
}
