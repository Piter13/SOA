package soa.lab8.models;

import java.sql.Timestamp;
import java.util.Set;

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
@Table(name = "RENT")
public class Rent {
	@Id
	@Column(name = "RENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "RENT_DATE")
	private Timestamp rentDate;
	
	@Column(name = "RETURN_DATE")
	private Timestamp returnDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private UserEntity userEntity;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOK_ID")
	private Book book;

	public Rent(Timestamp rentDate, Timestamp returnDate, UserEntity userEntity, Book book) {
		super();
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.userEntity = userEntity;
		this.book = book;
	}
	
	public Rent() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getRentDate() {
		return rentDate;
	}

	public void setRentDate(Timestamp rentDate) {
		this.rentDate = rentDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public UserEntity getUser() {
		return userEntity;
	}

	public void setUser(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Book getBooks() {
		return book;
	}

	public void setBooks(Book book) {
		this.book = book;
	}
	
	


	

}
