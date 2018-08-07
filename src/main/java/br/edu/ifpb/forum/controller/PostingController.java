package br.edu.ifpb.forum.controller;

import java.util.List;

import br.edu.ifpb.forum.dao.PersistenceUtil;
import br.edu.ifpb.forum.dao.PostingDAO;
import br.edu.ifpb.forum.entities.Posting;

public class PostingController {

	public void cadastrar(Posting post) {
		PostingDAO dao = new PostingDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.insert(post);
		dao.commit();
	}
	
	public void remover(Posting post) {
		PostingDAO dao = new PostingDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.delete(post);
		dao.commit();
	}
	
	public List<Posting> consultar() {
		PostingDAO dao = new PostingDAO(PersistenceUtil.getCurrentEntityManager());
		List<Posting> posts = dao.findAll();
		return posts;
	}
	
	public Posting consultarPorId(String id) {
		PostingDAO dao = new PostingDAO(PersistenceUtil.getCurrentEntityManager());
		return dao.find(Integer.parseInt(id));
	}
	public List<Posting> consultarPorTema(String theme_id) {
		PostingDAO dao = new PostingDAO(PersistenceUtil.getCurrentEntityManager());
		List<Posting> posts = dao.findAllByColumn("theme_id", theme_id);
		return posts;
	}
	
	public List<Posting> buscar(String filter, String theme_id) {
		PostingDAO dao = new PostingDAO(PersistenceUtil.getCurrentEntityManager());
		return dao.findByFilter(filter, theme_id);
	}
	
}
