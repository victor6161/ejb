package com.iba.kozlov.db.dao;

import com.iba.kozlov.db.xception.CriteriaNullException;

public class BookQueryFacade {

	public static String getQueryUpdateBook() {
		return "UPDATE book SET price=?,bookname=?,writer_id=?  WHERE id=?";
	}

	public static String getQueryInsertBook() {
		return "INSERT INTO book (bookname, price,writer_id,reader_id) VALUES (?,?,?,?)";
	}

	public static String getQueryIdWriterIdBook() {
		return "SELECT id,writer_id FROM book";
	}

	public static String getQueryBook(BookSearchCriteria pCriteria) throws CriteriaNullException {
		StringBuffer query = new StringBuffer(
				"SELECT  b.id,b.bookname,b.price,w.surname,r.surname,w.id,w.name FROM book as b LEFT JOIN reader as r ON b.reader_id=r.id LEFT JOIN writer as w ON b.writer_id=w.id");

		boolean bp = false;
		if (pCriteria == null) {
			throw new CriteriaNullException();

		}
		if (pCriteria.getAuthor() == null) {
			throw new CriteriaNullException();
		}
		if (pCriteria.getName() == null) {
			throw new CriteriaNullException();
		}
		if (pCriteria.getPrice() == null) {
			throw new CriteriaNullException();
		}

		if (pCriteria.isEmpty()) {
			return query.toString();
		} else {
			query.append(" where ");
		}

		if (pCriteria.getWritersId() != null) {
			for (Integer id : pCriteria.getWritersId()) {
				if (bp) {
					query.append(" or ");
				}
				bp = true;
				query.append("w.id='" + id + "'");
			}
		}

		if (!pCriteria.getReaderId().equals(0)) {
			if (bp) {
				query.append(" and ");
			}
			bp = true;
			query.append("r.id='" + pCriteria.getReaderId() + "'");
		}
		if (pCriteria.getBookId() != null) {
			if (bp) {
				query.append(" and ");
			}
			query.append("b.id='" + pCriteria.getBookId() + "'");
		}
		return query.toString();
	}
}
