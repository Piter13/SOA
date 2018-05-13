package paw.reverse;

import java.util.Date;

public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date createdAt;
	private String imie;
	private String nazwisko;
	private Date updatedAt;

	public Student() {
	}

	public Student(Date createdAt, String imie, String nazwisko) {
		this.createdAt = createdAt;
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	public Student(Date createdAt, String imie, String nazwisko, Date updatedAt) {
		this.createdAt = createdAt;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
