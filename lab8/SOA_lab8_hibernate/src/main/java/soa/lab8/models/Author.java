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
@Table(name = "AUTHOR")
public class Author {
	@Id
	@Column(name = "AUTHOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "AUTHOR_FIRSTNAME")
	private String firstname;
	
	@Column(name = "AUTHOR_LASTNAME")
	private String lastname;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="author")
	private Set<Book> book;

	public Author() {}

	public Author(String firstname, String lastname, Set<Book> book) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
}
