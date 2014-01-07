package ro.zerotohero.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.zerotohero.model.Role;

@Repository
public class RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Role> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Role> roleList = session.createQuery("from Role")
				.list();
		return roleList;
	}

	@Transactional
	public Role findById(int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.createQuery(
				"from Role where roleId = :id").setParameter("id",
				roleId).uniqueResult();
		return role;
	}

	@Transactional
	public void save(Role role) {
		Session session = sessionFactory.getCurrentSession();
		Role dbRole = findById(role.getRoleId()); 
		role.setRoleId(1);
		if ( dbRole != null){
			dbRole.setName(role.getName());
			dbRole.setAuthority(role.getAuthority());
			session.update(dbRole);
		}else{
			session.save(role);
		}
		
	}
	
	@Transactional
	public void delete(Role role) {
		Session session = sessionFactory.getCurrentSession();
		Role dbRole = findById(role.getRoleId()); 
		session.delete(dbRole);
		
	}

}
