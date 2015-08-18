package entity;
import javax.persistence.*;

@Entity @Table(name="users")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@Column(name="name")
	String name;
	@Column(name="email")
	String email;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public User() {}
	public User(Long id, String name, String email) {
		this.id       = id;
		this.name     = name;
		this.email    = email;
	}
}
