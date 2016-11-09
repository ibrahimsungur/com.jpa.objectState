package com.ibrahim.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ibrahim.model.Student;
import com.ibrahim.session.JpaEntityManagerFactory;
import com.ibrahim.util.TimeStampFactory;

public class Insert_Single_Student {

	private static EntityManager entityManager = JpaEntityManagerFactory.buildEntityManager();
	private static EntityTransaction transaction = JpaEntityManagerFactory.transaction();

	public static void main(String[] args) {
		insertTable();

	}

	public static void insertTable() {
		// transaction
		Student student = new Student(0, "Mehmet", "Sungur", 23423, TimeStampFactory.getCurrentTimeStamp(), null);

		// session baslangici
		transaction.begin();

		// persist
		entityManager.persist(student);
		student.setName("guncelleme 1");
		student.setName("guncellme 2");
		// persist

		transaction.commit();
		entityManager.close();
		student.setName("guncellme 3");
		// detached

	
	}

}
