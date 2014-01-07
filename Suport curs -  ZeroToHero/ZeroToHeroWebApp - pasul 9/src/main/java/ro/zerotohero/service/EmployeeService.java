package ro.zerotohero.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.dao.EmployeeDao;
import ro.zerotohero.model.Employee;

@Service  
@Transactional 
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll(); 
	}
	
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);		
	}
}
