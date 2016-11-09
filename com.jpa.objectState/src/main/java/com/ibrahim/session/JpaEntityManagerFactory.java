package com.ibrahim.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SuppressWarnings("unused")
public class JpaEntityManagerFactory {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	public static EntityManager buildEntityManager() {
		try {
			factory = Persistence.createEntityManagerFactory("com.jpa.objectState");
			entityManager = factory.createEntityManager();
		} catch (Exception e) {
			System.out.println("Entity Manager Calistirilmadi..." + e);
		}
		return entityManager;
	}

	public static EntityTransaction transaction() {
		return entityManager.getTransaction();
	}
}
