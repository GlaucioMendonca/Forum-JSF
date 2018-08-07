package br.edu.ifpb.forum.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.forum.controller.LoginController;
import br.edu.ifpb.forum.entities.User;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean extends GenericBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private User logado;
	private String user;
	private String password;
	LoginController ctr;
	
	public String autenticar (){
		
		String proxView = null;
		ctr = new LoginController();
		
		if ((logado = ctr.check(user, password)) != null) {
			this.setValueOf("#{sessionScope.loginUser}", String.class, logado.getRole().getRole());
			proxView = "index?faces-redirect=true";
		} else {
			FacesMessage msg = new FacesMessage("Login inválido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return proxView;
				
	}
	
	public String logout() {
		this.invalidateSession();
		return "login?faces-redirect=true";
	}

	public User getLogado() {
		return logado;
	}

	public void setLogado(User logado) {
		this.logado = logado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
