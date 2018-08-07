package br.edu.ifpb.forum.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.edu.ifpb.forum.dao.PersistenceUtil;
import br.edu.ifpb.forum.dao.ThemeDAO;
import br.edu.ifpb.forum.entities.Theme;

@ManagedBean
@ApplicationScoped
public class UtilBean {
	
	private List<Theme> themes;

	public List<Theme> getOperadoras() {
		ThemeDAO daoTheme = new ThemeDAO(PersistenceUtil.getCurrentEntityManager());
		this.themes = daoTheme.findAll();
		return this.themes;
	}
}
