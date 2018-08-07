package br.edu.ifpb.forum.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import br.edu.ifpb.forum.controller.PostingController;
import br.edu.ifpb.forum.entities.Posting;

@ManagedBean(name="editPostBean")
@ViewScoped
public class EditPostBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Posting post;
	private PostingController pctrl = new PostingController();
	public EditPostBean() {
	}

	@PostConstruct
	private void init() {
		this.post = new Posting();
	}
	
	public void onload() { 
		this.post = this.pctrl.consultarPorId(this.post.getId().toString());
	}
	
	public String salvar() {
		try {  
			this.pctrl.cadastrar(this.post);
			 this.addSuccessMessage("Postagem editada!");
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar editar a postagem");
		}
		return "post_message.xhtml?faces-redirect=true&post_id=" + this.post.getId();
	}
	
	public Posting getPost() {
		return post;
	}

	public void setPost(Posting post) {
		this.post = post;
	}
}
