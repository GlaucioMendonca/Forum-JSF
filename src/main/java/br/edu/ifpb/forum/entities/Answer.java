package br.edu.ifpb.forum.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_ANSWER")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date dateAnswer;
	
	@Column(length=255)
	private String message;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Posting post;
	
	public Answer() { }

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateAnswer() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");   
		return fmt.format(this.dateAnswer);
	}

	public void setDateAnswer(Date dateAnswer) {
		this.dateAnswer = dateAnswer;
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

	public Posting getPost() {
		return post;
	}

	public void setPost(Posting post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", dateAnswer=" + dateAnswer + ", message=" + message + ", user=" + user + "]";
	}




}