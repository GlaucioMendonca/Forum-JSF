package br.edu.ifpb.forum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.forum.entities.Theme;
import br.edu.ifpb.forum.dao.GenericDAO;

public class ThemeDAO extends GenericDAO<Theme, Integer>{
	private EntityManager em;
	
	public ThemeDAO(EntityManager em) {
		super(em);
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Theme> findByFilter(String filter) {
		try {
			Query q = this.em.createQuery("SELECT t FROM Theme t WHERE LOWER(t.theme) LIKE LOWER('%" + filter +"%')");
			return q.getResultList();

		}catch(NoResultException e){			
			return null;
		}
	}
}
