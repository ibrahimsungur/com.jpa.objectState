package com.ibrahim.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ibrahim.model.Student;
import com.ibrahim.session.JpaEntityManagerFactory;
import com.ibrahim.util.TimeStampFactory;

public class Insert_multiple_Student {

	private static EntityManager entityManager = JpaEntityManagerFactory.buildEntityManager();
	private static EntityTransaction transaction = JpaEntityManagerFactory.transaction();

	public static void main(String[] args) {
	//	insertTableStudentS1();
		inserTableStudentS2();

	}

	public static void insertTableStudentS1() {
		// transaction
		Student student = new Student(0, "Azad", "Kaya", 12345, TimeStampFactory.getCurrentTimeStamp(), null);

		// session baslangici
		transaction.begin();
		for (int i = 0; i < 20; i++) {
			entityManager.persist(student);
		}
		transaction.commit();
		entityManager.close();

	}

	public static void inserTableStudentS2() {
		// session nesnesi
		transaction.begin();
		for (int i = 0; i < 20; i++) {
			Student student = new Student(0, "Azad", "Kaya", 12345, TimeStampFactory.getCurrentTimeStamp(), null);
			entityManager.persist(student);
		}
		transaction.commit();
		// session nesnesi
		entityManager.close();

	}

}
