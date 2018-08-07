package br.edu.ifpb.forum.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifpb.forum.controller.UserController;

@ManagedBean(name="registerBean")
@SessionScoped
public class RegisterBean {
	private String nome;
	private String cpf;
	private String email;
	private String password;
	private String cPassword;
	private UserController ctr;
	
	public RegisterBean (){}
	
	public String store (){
		ctr = new UserController ();
		if(password.equals(cPassword)){
			if(ctr.createUser(nome, cpf, email, password)!= null)
			return "index?faces-redirect=true";
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	
	
}
