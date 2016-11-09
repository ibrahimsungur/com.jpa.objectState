package com.ibrahim.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ibrahim.model.Address;
import com.ibrahim.model.Student;
import com.ibrahim.session.JpaEntityManagerFactory;
import com.ibrahim.util.TimeStampFactory;

public class InsertTable {

	private static EntityManager entityManager = JpaEntityManagerFactory.buildEntityManager();
	private static EntityTransaction transaction = JpaEntityManagerFactory.transaction();

	public static void main(String[] args) {
		insertTable();

	}

	public static void insertTable() {
		Student student = new Student(0, "ibrahim", "sungur", 12345, TimeStampFactory.getCurrentTimeStamp(), null);
		Address address = new Address(0, "urfa", "Halfeti", TimeStampFactory.getCurrentTimeStamp(), null);

		// transaction baslangici
		transaction.begin();

		// persist
		entityManager.persist(student);
		entityManager.persist(address);
		// persist sonu

		transaction.commit();

		// session kapanisi
		entityManager.close();
	}

}
