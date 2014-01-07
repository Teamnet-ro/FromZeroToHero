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
		List<Employee> employeeList = session.createQuery("from Employee")
				.list();
		return employeeList;
	}

	@Transactional
	public Employee findById(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.createQuery(
				"from Employee where employeeId = :id").setParameter("id",
				employeeId).uniqueResult();
		
		return employee;
	}

	@Transactional
	public void save(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee dbEmployee = findById(employee.getEmployeeId()); 
		if ( dbEmployee != null){
			dbEmployee.setEmail(employee.getEmail());
			dbEmployee.setFirstName(employee.getFirstName());
			dbEmployee.setLastName(employee.getLastName());
			dbEmployee.setPassword(employee.getPassword());
			session.update(dbEmployee);
		}else{
			session.saveOrUpdate(employee);
		}
		
	}
	
	@Transactional
	public void delete(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee dbEmployee = findById(employee.getEmployeeId()); 
		session.delete(dbEmployee);
		
	}

}
