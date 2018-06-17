package pl.marganski.soa.jpa.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "USERS")
@XmlRootElement
@EqualsAndHashCode(exclude = {"castles"})
@NamedQueries({ 
@NamedQuery(name="user.specificUser", query="SELECT u FROM User u where u.id =:id"),
@NamedQuery(name="user.specificUserByName", query="SELECT u FROM User u where u.username =:username"),
@NamedQuery(name="user.allUsers", query="SELECT u FROM User u"), })
public class User {
	@Id
	@Column(name = "User_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Castle> castles = new LinkedHashSet<Castle>();

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@XmlTransient
	public Set<Castle> getCastles() {
		return castles;
	}

	public void setCastles(Set<Castle> castles) {
		this.castles = castles;
	}

	public enum Role {
		Admin, User
	}

}
