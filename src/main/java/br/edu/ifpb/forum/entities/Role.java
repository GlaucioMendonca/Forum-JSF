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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_ROLE")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50)
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name="role_id")
	private List<User> users = new ArrayList<>();
	
	public Role() { }

	public Integer getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		this.users.add(user);
		user.setRole(this);
	}
}