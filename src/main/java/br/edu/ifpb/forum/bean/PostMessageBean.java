package br.edu.ifpb.forum.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import br.edu.ifpb.forum.controller.AnswerController;
import br.edu.ifpb.forum.controller.PostingController;
import br.edu.ifpb.forum.controller.UserController;
import br.edu.ifpb.forum.entities.Answer;
import br.edu.ifpb.forum.entities.Posting;

@ManagedBean(name="postMessageBean")
@ViewScoped
public class PostMessageBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Posting post;
	private Answer answer;
	private PostingController pctrl = new PostingController();
	private UserController uctrl = new UserController();
	private AnswerController actrl = new AnswerController();

	public PostMessageBean() {
	}

	@PostConstruct
	private void init() {
		this.post = new Posting();
		this.answer = new Answer();
	}
	
	public void onload() { 
		this.post = this.pctrl.consultarPorId(this.post.getId().toString());
	}
	
	public String comentar() {
		try {  
		    this.answer.setDateAnswer(new Date());
		    this.answer.setPost(this.post);
		    this.answer.setUser(this.uctrl.consultarPorId("1"));
		    
		    this.post.addAnswer(this.answer);
		    
		    System.out.println(this.answer.getPost());
		    this.actrl.cadastrar(this.answer);
		    this.pctrl.cadastrar(this.post);
		    
		    this.answer = new Answer();
		    this.addSuccessMessage("Comentário cadastrado!");
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar salvar o comentário");
		}
		return "post_message.xhtml?faces-redirect=true&post_id=" + this.post.getId();
	}
	
	public String removerPost() {
		try {  
		    this.pctrl.remover(this.post);
		    this.addSuccessMessage("Postagem removida!");
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar remover a postagem");
		}
		return "posts.xhtml?faces-redirect=true&theme_id=" + this.post.getTheme().getId();
	}
	
	public String removerAnswer(String id) {
		try {
			this.actrl.remover(actrl.consultarPorId(id));
			this.addSuccessMessage("Comentário removido!");
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar remover o comentário");
		}
		return "post_message.xhtml?faces-redirect=true&post_id=" + this.post.getId();
	}
	
	public Posting getPost() {
		return post;
	}

	public void setPost(Posting post) {
		this.post = post;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	
}
