package br.edu.ifpb.forum.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import br.edu.ifpb.forum.controller.AnswerController;
import br.edu.ifpb.forum.entities.Answer;

@ManagedBean(name="editAnswerBean")
@ViewScoped
public class EditAnswerBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Answer answer;
	private AnswerController actrl = new AnswerController();
	public EditAnswerBean() {
	}

	@PostConstruct
	private void init() {
		this.answer = new Answer();
	}
	
	public void onload() { 
		this.answer = this.actrl.consultarPorId(this.answer.getId().toString());
	}
	
	public String salvar() {
		try {  
			this.actrl.cadastrar(this.answer);
			 this.addSuccessMessage("Coment�rio editado!");
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar editar o coment�rio");
		}
		return "post_message.xhtml?faces-redirect=true&post_id=" + this.answer.getPost().getId();
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
