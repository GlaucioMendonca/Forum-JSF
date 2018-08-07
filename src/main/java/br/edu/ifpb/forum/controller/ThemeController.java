package br.edu.ifpb.forum.controller;

import java.util.List;

import br.edu.ifpb.forum.dao.PersistenceUtil;
import br.edu.ifpb.forum.dao.ThemeDAO;
import br.edu.ifpb.forum.entities.Theme;

public class ThemeController {

	public void cadastrar(Theme theme) {
		ThemeDAO dao = new ThemeDAO(PersistenceUtil.getCurrentEntityManager());
		
		dao.beginTransaction();
		dao.insert(theme);
		dao.commit();
	}
	
	public List<Theme> buscar(String filter) {
		ThemeDAO dao = new ThemeDAO(PersistenceUtil.getCurrentEntityManager());
		
		List<Theme> themes = dao.findByFilter(filter);
		
		return themes;
	}
	
	public Theme consultarPorId(String id) {
		ThemeDAO dao = new ThemeDAO(PersistenceUtil.getCurrentEntityManager());
		return dao.find(Integer.parseInt(id));
	}
}
