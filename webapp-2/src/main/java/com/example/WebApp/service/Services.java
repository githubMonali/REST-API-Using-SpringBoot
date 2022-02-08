package com.example.WebApp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.WebApp.Entity.Book;
import com.example.WebApp.dao.Repository;

@Service
public class Services {
    
	@Autowired
	private Repository repository;
	
	/*
	 * private static List<Book> list = new ArrayList<>(); static {
	 * 
	 * list.add(new Book(10,"Java","abc")); list.add(new Book(11,"Java","lmn"));
	 * list.add(new Book(12,"Java","xyz"));
	 * 
	 * }
	 */
	public List<Book> getAllBooks()
	{   
		List<Book> list=(List<Book>) this.repository.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
      try {
	      //book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    	  book=this.repository.findById(id);
    	  
		}catch(Exception e) {
          e.printStackTrace();
    	}
	  return book;
	}

	 public Book addBook(Book b) {
		Book result=repository.save(b);
		//list.add(b);
		return result;
	}

	public void deleteBook(int bid) {

		repository.deleteById(bid);
		
		//list = list.stream().filter(book -> book.getId() == bid).collect(Collectors.toList());
	}

	public void updateBook(Book book, int bookid) {
         book.setId(bookid);
		repository.save(book);
		
		
		/*
		 * list = list.stream().map(b -> { if (b.getId() == bookid) {
		 * b.setTitle(book.getTitle()); b.setAuthor(book.getAuthor()); } return b;
		 * }).collect(Collectors.toList());
		 */
	}

}
