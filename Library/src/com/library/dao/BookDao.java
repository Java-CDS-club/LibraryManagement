package com.library.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.library.model.Book;

public class BookDao {
	public static void create(Book b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(b);
		session.beginTransaction().commit();
		session.close();
	}

	public static List<Book> show() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		Root<Book> bookRoot = criteria.from(Book.class);
		criteria.select(bookRoot);
//		criteria.where(builder.equal(librarianRoot.get("name"), "Ramesh"));
		List<Book> bookList = session.createQuery(criteria).getResultList();
		return bookList;
	}

//	public static void main(String[] args) {
//		Book b = new Book("A@4", "C In Depth", "Shrivastav", "BPB", 5, new Date());
//		Book b1 = new Book("B@1", "DBMS", "Korth", "Pearson", 12, new Date());
//		Book b2 = new Book("G@12", "Let's see", "Yashwant Kanetkar", "BPB", 15, new Date());
//		BookDao.create(b);
//		BookDao.create(b1);
//		BookDao.create(b2);
//		System.out.println("Success");
//	}

}
