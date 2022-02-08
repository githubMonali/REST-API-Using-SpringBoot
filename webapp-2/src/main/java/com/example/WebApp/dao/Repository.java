package com.example.WebApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.WebApp.Entity.Book;

public interface Repository extends CrudRepository<Book,Integer>{
	public Book findById(int id);

}
