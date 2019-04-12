package br.com.gambisoft.bookritics.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book implements Comparable<Book>{
	
	@Id
	private String id;
	
	@Indexed(unique=true)
	private String name;
	private String author;
	private String description;
	private String publisher;
	private String registrationNumber;
	private String urlImage;
	private Float rating = 0f;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
	@Override
	public int compareTo(Book compareBook) {
		
		if ( this.getRating() > compareBook.getRating() ) return -1;
        else if ( this.getRating() == compareBook.getRating() ) return 0;
        else return 1;
		
	}	
	
}
