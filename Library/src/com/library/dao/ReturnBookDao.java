package com.library.dao;

import org.hibernate.Session;

import com.library.model.Book;
import com.library.model.Issued;
import com.library.model.IssuedBooks;

public class ReturnBookDao {
	public static void delete(String bookcallno, String studentid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		IssuedBooks issuedbook = session.load(IssuedBooks.class, new Issued(bookcallno, studentid));
		session.delete(issuedbook);
		ReturnBookDao.updatebook(bookcallno);
		session.beginTransaction().commit();
	}

	public static void updatebook(String bookcallno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Book book = session.load(Book.class, bookcallno);
		book.setIssued(book.getIssued() - 1);
		book.setQuantity(book.getQuantity() + 1);
		session.update(book);
		session.beginTransaction().commit();
	}
}
