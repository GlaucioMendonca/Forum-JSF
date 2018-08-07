package br.edu.ifpb.forum.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import br.edu.ifpb.forum.controller.PostingController;
import br.edu.ifpb.forum.controller.ThemeController;
import br.edu.ifpb.forum.controller.UserController;
import br.edu.ifpb.forum.entities.Posting;
import br.edu.ifpb.forum.entities.Theme;

@ManagedBean(name="postBean")
@ViewScoped
public class PostBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Posting> posts;
	private Posting post;
	private Theme theme;
	private String filter;
	PostingController pctrl = new PostingController();
	ThemeController tctrl = new ThemeController();
    UserController uctrl = new UserController();
    
	public PostBean() {
	}

	@PostConstruct
	private void init() {
		this.theme = new Theme();
		this.post = new Posting();
		this.filter = "";
		this.posts = this.pctrl.buscar(this.filter, "0");
	}
	
	public void onload() {
		this.theme = this.tctrl.consultarPorId(this.theme.getId().toString());
	}
	
	public String salvar() {
		try {  
		    this.post.setUser(this.uctrl.consultarPorId("1"));
		    this.post.setTheme(this.theme);
		    this.post.setDatePosting(new Date());
		    
		    this.pctrl.cadastrar(this.post);
		    this.post = new Posting();
		    this.addSuccessMessage("Postagem cadastrada!");
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar salvar a postagem");
		}
		return "posts.xhtml?faces-redirect=true&theme_id=" + this.theme.getId();
	}
	
	public String pressButton() {
		return "posts.xhtml?faces-redirect=true&theme_id=" + this.theme.getId().toString() + "&filter=" + this.filter;
	}
	
	public List<Posting> getPosts() {
		this.posts = this.pctrl.buscar(this.filter, this.theme.getId().toString());
		return this.posts;
	}

	public void setPosts(List<Posting> posts) {
		this.posts = posts;
	}
	
	public Posting getPost() {
		return post;
	}

	public void setPost(Posting post) {
		this.post = post;
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
	
}
