package br.edu.ifpb.forum.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.forum.entities.Answer;
import br.edu.ifpb.forum.dao.GenericDAO;

public class AnswerDAO extends GenericDAO<Answer, Integer>{
	public AnswerDAO(EntityManager em) {
		super(em);
	}
}
