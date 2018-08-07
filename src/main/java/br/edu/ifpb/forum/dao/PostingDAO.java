package br.edu.ifpb.forum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.forum.entities.Posting;

public class PostingDAO extends GenericDAO<Posting, Integer>{
	public PostingDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Posting> findByFilter(String filter, String theme_id) {
		try {
			Query q = this.entityManager.createQuery(
						"SELECT p FROM Posting p WHERE " + 
						"(p.theme.id =" + theme_id + "AND LOWER(p.title) LIKE LOWER('%" + filter + "%'))" + 
						"OR (p.theme.id =" + theme_id + "AND LOWER(p.message) LIKE LOWER('%" + filter + "%'))");

			return q.getResultList();

		}catch(NoResultException e){			
			return null;
		}
	}
}
