package com.library.dao;

import org.hibernate.Session;

import com.library.model.Student;

public class StudentDao {
	public static void insert(Student s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(s);
		session.beginTransaction().commit();
		session.close();
	}

//	public static void main(String[] args) {
//		Student std = new Student("1234", "Ramesh", "9876543210");
//		Student std1 = new Student("5678", "Suresh", "9876543210");
//		Student std2 = new Student("9015", "Mahesh", "9876543210");
//		Student std3 = new Student("7642", "Amit", "9876543210");
//		Student std4 = new Student("7813", "Ravi", "9876543210");
//		StudentDao.insert(std);
//		StudentDao.insert(std1);
//		StudentDao.insert(std2);
//		StudentDao.insert(std3);
//		StudentDao.insert(std4);
//		System.out.println("Success");
//	}
}
