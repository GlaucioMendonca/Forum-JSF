package br.edu.ifpb.forum.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.forum.entities.User;
import br.edu.ifpb.forum.dao.GenericDAO;

public class UserDAO extends GenericDAO<User, Integer>{
	
	public UserDAO(EntityManager em) {
		super(em);
	}
	
	public User buscaLogin (String email) throws Exception{
		User user = null;
		Query q = entityManager.createQuery("select u from User as u where u.email like '"+email+"'");
		
		try {
			user = (User) q.getSingleResult();
		
		} catch (NoResultException e) {
			throw new Exception ("Usuário não existe.");
		}
		
		if(user.getEmail()==null){
			throw new Exception ("Usuário não existe.");
		}
		
		return user;
	}
	
	public User buscaCpf (String cpf) throws Exception{
		User user = null;
		Query q = entityManager.createQuery("select u from User as u where u.cpf like '"+cpf+"'");
		
		try {
			user = (User) q.getSingleResult();
		
		} catch (NoResultException e) {
			throw new Exception ("Usuário não existe.");
		}
		
		if(user.getEmail()==null){
			throw new Exception ("Usuário não existe.");
		}
		
		return user;
	}
}
