package com.iba.kozlov.bl.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dao.BookDao;
import com.iba.kozlov.db.dao.BookSearchCriteria;

import com.iba.kozlov.db.dto.BookDto;
import com.iba.kozlov.db.dto.WriterDto;

@Stateless
public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);
	BookDao bookDao = new BookDao();

	@Override
	public List<BookDto> readBooks() {
		LOGGER.info("createBooks method");
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria();
		return bookDao.read(bookSearchCriteria);
	}

	@Override
	public void addBooks(BookDto bookDto) {
		LOGGER.info("addBook ");

		bookDto.getWriter().getSurname();
		LOGGER.info("author " + bookDto.getWriter().getSurname());
		int writerId = new WriterServiceImpl().findIdBySurname(bookDto.getWriter().getSurname());
		if (new Integer(writerId).equals(0)) {
			new WriterServiceImpl().createWriter(new WriterDto(bookDto.getWriter().getSurname()));
			writerId = new WriterServiceImpl().findIdBySurname(bookDto.getWriter().getSurname());
			bookDto.setWriterId(writerId);
		} else {
			bookDto.setWriterId(writerId);
		}
		bookDao.addBook(bookDto);
	}

	@Override
	public void editBooks(BookDto bookDto) {
		LOGGER.info("editBook" + bookDto.toString());
		new BookDao().updateAll(bookDto);// ??? ����������
		/*new WriterDao().update(bookDto);*/

	}

	public int findWriterIdInBook(int bookId) {
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria();
		List<BookDto> bookDto = new BookDao().readId(bookSearchCriteria);

		for (BookDto bookDtoItem : bookDto) {
			if (new Integer(bookDtoItem.getId()).equals(bookId)) {
				return bookDtoItem.getWriterId();
			}
		}
		return 0;
	}

	@Override
	public List<BookDto> searchBooks(BookDto bookDto) {
		LOGGER.info("createBooks method");
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria();
		List<Integer> resultId = new ArrayList<>();
		if (bookDto.getWriters() != null) {
			for (WriterDto writer : bookDto.getWriters()) {
				resultId.add(writer.getId());
				LOGGER.info("****************" + writer.getSurname() + writer.getId());
			}
			bookSearchCriteria.setWritersId(resultId);
		}

	
		if (bookDto.getReader() != null) {
			bookSearchCriteria.setReaderId(bookDto.getReader().getId());
		}
		if (bookDto.getId() != null) {
			bookSearchCriteria.setBookId(bookDto.getId());
		}
		return bookDao.read(bookSearchCriteria);
	}



}
