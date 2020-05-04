package com.book_store.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Book {
		
		//Attributes
		//PRIMARY KEY TABLE book
		@Id
		@GeneratedValue
		private long idBook;
		
		private String name;
		private int year;
		
		//One Book - One BookDetails
		@OneToOne(cascade = CascadeType.ALL)
		//Relation with PK
		@PrimaryKeyJoinColumn
		private BookDetails bookDetails;
		
		//Methods Setters and Getters
		public void setIdBook(long idBook){
			this.idBook = idBook;
		}
		public long getIdBook(){
			return idBook;
		}
		public void setName(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public void setBookDetails( BookDetails bookDetails){
			this.bookDetails = bookDetails;
		}
		public BookDetails getBookDetails(){
			return bookDetails;
		}
}
