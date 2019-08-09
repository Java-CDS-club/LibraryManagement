package com.library.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.library.model.Librarian;

public class LibrarianDao {
	public static void insert(Librarian l) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(l);
		session.beginTransaction().commit();
		session.close();
	}

	public static void delete(String user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Librarian l = session.load(Librarian.class, user);
		session.delete(l);
		session.beginTransaction().commit();
	}

	public static boolean validate(String user, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Librarian a = session.load(Librarian.class, user);
			if (a.getPassword().equals(password)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return false;
	}

	public static List<Librarian> show() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Librarian> criteria = builder.createQuery(Librarian.class);
		Root<Librarian> librarianRoot = criteria.from(Librarian.class); // mention the class in case of inheritance
		criteria.select(librarianRoot);
//		criteria.where(builder.equal(librarianRoot.get("name"), "Ramesh"));
//		Query q = session.createQuery(criteria); // execute single query
//		System.out.println(q.getSingleResult()); // get single result
		List<Librarian> librarianList = session.createQuery(criteria).getResultList();
		return librarianList;

	}

//	public static void main(String[] args) {
//
//		Librarian l = new Librarian("Prabhakar", "ppp", "prabhakar@gmail.com", "Sec-62", "noida", "9998328238");
//		Librarian l1 = new Librarian("sumedh", "sumesh", "sumesh@gmail.com", "Anand Vihar", "Delhi", "9382393823");
//		Librarian l2 = new Librarian("abhi", "abhi", "abhi@gmail.com", "Rajnagar", "Ghaziabad", "9239328323");
//		LibrarianDao.insert(l);
//		LibrarianDao.insert(l1);
//		LibrarianDao.insert(l2);
//		System.out.println("Success");
//	}
}
