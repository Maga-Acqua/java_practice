package com.book_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.book_store.model.Book;
import com.book_store.model.BookDetails;
import com.book_store.model.DaoBook;
import com.book_store.model.DaoBookDetails;

@Controller
public class MainController {
	
	@Autowired
	private DaoBook daoBook;
	
	@Autowired
	private DaoBookDetails daoBookDetails;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView homeGet() {
		ModelAndView modelAndView = new ModelAndView();
		//daoBook.findAll() let us see all the books register in the database
		modelAndView.addObject("bookList", daoBook.findAll());
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.GET)
	public ModelAndView formularioGet(){
		ModelAndView modelAndView = new ModelAndView();
		//Create new objects -> Book and BookDetails
		BookDetails bookDetails = new BookDetails();
		modelAndView.addObject("details", bookDetails);
		Book book = new Book();
		modelAndView.addObject("book", book);
		
		modelAndView.setViewName("create");
		return modelAndView;
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public ModelAndView formularioPost(@ModelAttribute Book book,
										@ModelAttribute BookDetails bookDetails){
		daoBook.save(book);
		bookDetails.setIdBookDetails(book.getIdBook());
		book.setBookDetails(bookDetails);
		daoBook.save(book);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookList", daoBook.findAll());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteBook(@RequestParam("idBook") long idBook){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("book", daoBook.findOne(idBook));
		modelAndView.addObject("details", daoBook.findOne(idBook));
		daoBook.delete(idBook);
		
		modelAndView.addObject("bookList", daoBook.findAll());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public ModelAndView updateBook(@RequestParam("idBook") long idBook) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("book", daoBook.findOne(idBook));
    	modelAndView.addObject("details", daoBookDetails.findOne(idBook));
        
    	modelAndView.setViewName("edit");
		return modelAndView;
    }
    
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public ModelAndView updateBook(@ModelAttribute Book book,
    									@ModelAttribute BookDetails details) {
    	ModelAndView modelAndView = new ModelAndView();
    	daoBook.save(book);
    	details.setIdBookDetails(book.getIdBook());
		book.setBookDetails(details);
		daoBook.save(book);
		modelAndView.addObject("bookList", daoBook.findAll());
		
		modelAndView.setViewName("index");
		return modelAndView;
    }
}
