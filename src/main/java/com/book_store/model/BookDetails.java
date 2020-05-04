package com.book_store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="book_details")
public class BookDetails {
			//Attributes
			//PRIMARY KEY TABLE book-details
			@Id
			private long idBookDetails;
	
			private String author;
			private String editorial;
			
			//Method Setters and Getters
			public void setIdBookDetails(long idBookDetails){
				this.idBookDetails = idBookDetails;
			}
			public long getIdBookDetails(){
				return idBookDetails;
			}
			public void setAuthor(String author){
				this.author = author;
			}
			public String getAuthor(){
				return author;
			}
			public void setEditorial(String editorial){
				this.editorial = editorial;
			}
			public String getEditorial(){
				return editorial;
			}
}
