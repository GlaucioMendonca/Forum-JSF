package br.edu.ifpb.forum.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_POSTING")
public class Posting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date datePosting;
	
	@Column(length=100)
	private String title;
	
	@Column(length=255)
	private String message;
	
	@ManyToOne
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name="post_id")
	private List<Answer> answers = new ArrayList<>();
	
	@ManyToOne
	private Theme theme;
	
	public Posting() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDatePosting() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");   
		return fmt.format(this.datePosting);
	}

	public void setDatePosting(Date datePosting) {
		this.datePosting = datePosting;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
		answer.setPost(this);
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	@Override
	public String toString() {
		return "Posting [id=" + id + ", datePosting=" + datePosting + ", title=" + title + ", message=" + message
				+ ", user=" + user + ", answers=" + answers + ", theme=" + theme + "]";
	}
}
