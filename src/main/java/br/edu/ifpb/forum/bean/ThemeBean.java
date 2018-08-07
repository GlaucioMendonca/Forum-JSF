package br.edu.ifpb.forum.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import br.edu.ifpb.forum.controller.ThemeController;
import br.edu.ifpb.forum.entities.Theme;

@ManagedBean(name="themeBean")
@ViewScoped
public class ThemeBean extends GenericBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Theme> themes;
	private Theme theme;
	private String filter;
	ThemeController ctrl = new ThemeController();
	
	/** TODO
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	*/
	
	@PostConstruct
	private void init() {
		this.theme  = new Theme();
		this.filter = "";
		this.themes = this.ctrl.buscar(this.filter);
	}

	public String salvar() {
		try {
			this.ctrl.cadastrar(this.theme);
			this.theme  = new Theme();
			this.addSuccessMessage("Tema cadastrado!");
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar salvar o tema");
		}
		return null;
	}
	
	public String pressButton() {
		return "index.xhtml?faces-redirect=true&filter=" + this.filter;
	}

	public List<Theme> getThemes() {
		this.themes = this.ctrl.buscar(this.filter);
		this.theme  = new Theme();
		
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
