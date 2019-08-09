package com.library.dao;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.library.model.Book;
import com.library.model.Issued;
import com.library.model.IssuedBooks;
import java.util.List;

public class IssueBookDao {

	public static boolean checkBook(String bookcallno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Book b = session.load(Book.class, bookcallno);
		if (b.getQuantity() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void save(String bookcallno, String studentid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		IssuedBooks i = new IssuedBooks(new Issued(bookcallno, studentid), new Date());
		session.save(i);
		session.beginTransaction().commit();
		updatebook(bookcallno);

	}

	public static void updatebook(String bookcallno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Book b = session.load(Book.class, bookcallno);
		b.setQuantity(b.getQuantity() - 1);
		b.setIssued(b.getIssued() + 1);
		session.update(b);
		session.beginTransaction().commit();

	}

	public static List<IssuedBooks> show() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<IssuedBooks> criteria = builder.createQuery(IssuedBooks.class);
		Root<IssuedBooks> issuedBookRoot = criteria.from(IssuedBooks.class);
		criteria.select(issuedBookRoot);
//		criteria.where(builder.equal(librarianRoot.get("name"), "Ramesh"));
		List<IssuedBooks> issuedBooksList = session.createQuery(criteria).getResultList();
		return issuedBooksList;
	}
}
