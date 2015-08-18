package entity;
import javax.persistence.*;

@Entity @Table(name="posts")
public class Post {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@Column(name="user")
	Long user;
	@Column(name="topic")
	String topic;
	@Column(name="detail")
	String detail;
	
	public Long getId() { return id; };
	public void setId(Long id) { this.id = id; }
	public Long getUser() { return user; }
	public void setUser(Long user) { this.user = user; }
	public String getTopic() { return topic; }
	public void setTopic(String topic) { this.topic = topic; }
	public String getDetail() { return detail; }
	public void setDetail(String detail) { this.detail = detail; }
	public Post() {}
	public Post(Long id, Long user, String topic, String detail) {
		this.id     = id;
		this.user   = user;
		this.topic  = topic;
		this.detail = detail;
	}
}
