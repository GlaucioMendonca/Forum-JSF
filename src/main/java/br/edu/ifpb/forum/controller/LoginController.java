package br.edu.ifpb.forum.controller;

import br.edu.ifpb.forum.dao.PersistenceUtil;
import br.edu.ifpb.forum.dao.UserDAO;
import br.edu.ifpb.forum.entities.User;

public class LoginController {
	
	public User check (String usuario, String senha){
		
		User user = null;
		UserDAO dao = new UserDAO(PersistenceUtil.getCurrentEntityManager());
		
		try {
			user = dao.buscaLogin(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (user.getEmail() != null && user.getPassword() != null) {

			if (senha.equals(user.getPassword())) {
				return user;
			}

		} else {
			System.out.println("Erro inesperado");

		}
		
		return null;
	}
}
