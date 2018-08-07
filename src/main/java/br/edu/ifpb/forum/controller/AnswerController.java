package br.edu.ifpb.forum.controller;

import br.edu.ifpb.forum.dao.AnswerDAO;
import br.edu.ifpb.forum.dao.PersistenceUtil;
import br.edu.ifpb.forum.entities.Answer;

public class AnswerController {

	public void cadastrar(Answer answer) {
		AnswerDAO dao = new AnswerDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.insert(answer);
		dao.commit();
	}
	
	public void remover(Answer answer) {
		AnswerDAO dao = new AnswerDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.delete(answer);
		dao.commit();
	}
	
	public Answer consultarPorId(String id) {
		AnswerDAO dao = new AnswerDAO(PersistenceUtil.getCurrentEntityManager());
		return dao.find(Integer.parseInt(id));
	}
}
