package ro.zerotohero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.dao.RoleDao;
import ro.zerotohero.model.Role;

@Service  
@Transactional 
public class RoleService {
	@Autowired
	private RoleDao roleDao;

	@Transactional
	public List<Role> findAll() {
		return roleDao.findAll(); 
	}
	
	@Transactional
	public void save(Role role) {
		roleDao.save(role);		
	}
	
	@Transactional
	public Role findById(int roleId) {
		return roleDao.findById(roleId);
	}
	public void delete(Role role) {
		roleDao.delete(role);
	}
}
