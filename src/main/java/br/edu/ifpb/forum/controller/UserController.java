package br.edu.ifpb.forum.controller;

import br.edu.ifpb.forum.dao.PersistenceUtil;
import br.edu.ifpb.forum.dao.RoleDAO;
import br.edu.ifpb.forum.dao.UserDAO;
import br.edu.ifpb.forum.entities.Role;
import br.edu.ifpb.forum.entities.User;

public class UserController {
		
	public User consultarPorId(String id) {
		UserDAO dao = new UserDAO(PersistenceUtil.getCurrentEntityManager());
		return dao.find(Integer.parseInt(id));
	}

	public User createUser (String nome, String cpf, String email, String senha){
		
		UserDAO dao = new UserDAO(PersistenceUtil.getCurrentEntityManager());
		RoleDAO roledao = new RoleDAO(PersistenceUtil.getCurrentEntityManager());
		User user = null;
		
		try{
			
			user = dao.buscaLogin(email);
			
			return null;
			
		}catch (Exception e) {
			
		}
		
		Role role = (Role) roledao.find(2);
		
		user = new User(cpf, nome, email, senha, role);
		
		dao.beginTransaction();
		dao.insert(user);
		dao.commit();
		
		return user;
	}


}
