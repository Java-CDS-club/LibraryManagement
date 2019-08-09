package com.library.dao;

import org.hibernate.Session;
import com.library.model.Admin;
import com.library.model.LoginID;

public class AdminDao {
	public void insert(String user, String password, String a_name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Admin admin = new Admin();
		LoginID LoginID = new LoginID(user, password);
		admin.setA_name(a_name);
		admin.setId(LoginID);
		session.save(admin);
		session.beginTransaction().commit();
		session.close();
	}

	public static boolean validate(String user, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Admin a = session.load(Admin.class, new LoginID(user, password));
		if ((a.getId().getPassword()).equals(password)) {
			return true;
		}
		return false;
	}

	public static void logout() {
		HibernateUtil.shutdown();
	}

//	public static void main(String[] args) {
//		AdminDao a = new AdminDao();
//		a.insert("admin", "admin", "Amol");
//		System.out.println("Success");
//
//	}

}
