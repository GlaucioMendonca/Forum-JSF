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
@Table(name="TB_THEME")
public class Theme {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100)
	private String theme;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name="theme_id")
	private List<Posting> posts = new ArrayList<>();
	
	public Theme() { }

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Posting> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Posting> posts) {
		this.posts = posts;
	}
	
	public void addPost(Posting post) {
		this.posts.add(post);
		post.setTheme(this);
	}

	@Override
	public String toString() {
		return "Theme [theme=" + theme + "]";
	}
}