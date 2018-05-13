package soa.lab8.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserEntity")
public class UserEntity {
	@Id
	@Column(name = "USER_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name = "USER_NAME")
	private String user_name;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="userEntity")
	private Set<Rent> rents;
	
	public UserEntity() {}
	
	public UserEntity(String name, Set<Rent> rents) {
		super();
		this.user_name = name;
		this.rents = rents;
	}
	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String name) {
		this.user_name = name;
	}

	public Set<Rent> getRents() {
		return rents;
	}

	public void setRents(Set<Rent> rents) {
		this.rents = rents;
	}

}
