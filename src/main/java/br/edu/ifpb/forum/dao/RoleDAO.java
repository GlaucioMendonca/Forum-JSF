package br.edu.ifpb.forum.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.forum.entities.Role;

public class RoleDAO extends GenericDAO<Role, Integer>{
	
	public RoleDAO (EntityManager em){
		super(em);
	}
	
}
