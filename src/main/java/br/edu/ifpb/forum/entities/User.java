package br.edu.ifpb.forum.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=11, unique=true)
	private String cpf;
	
	@Column(length=100)
	private String name;
	
	@Column(length=100)
	private String sobrenome;
	
	@Column(length=100)
	private String email;
	
	@Column(length=100)
	private String password;
	
	@ManyToOne
	private Role role;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name="user_id")
	private List<Posting> posts = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name="user_id")
	private List<Answer> answers = new ArrayList<>();
	
	public User() { }
	

	public User(String cpf, String name, String email, String password, Role role) {
		super();
		
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public Integer getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Posting> getPosts() {
		return posts;
	}

	public void addPosting(Posting post) {
		this.posts.add(post);
		post.setUser(this);
	}

	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
		answer.setUser(this);
	}
}