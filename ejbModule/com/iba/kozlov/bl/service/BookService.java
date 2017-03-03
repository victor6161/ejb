/**
 * 
 */
package com.iba.kozlov.bl.service;

import java.util.List;

import javax.ejb.Local;

import com.iba.kozlov.db.dto.BookDto;



@Local
public interface BookService {

	void addBooks(BookDto bookDto);
	List<BookDto> readBooks();
	void editBooks(BookDto BookDto);
	List<BookDto> searchBooks(BookDto bookDto);
	



	

	
}
