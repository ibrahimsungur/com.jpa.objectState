package com.ibrahim.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ibrahim.model.Student;
import com.ibrahim.session.JpaEntityManagerFactory;

public class deleteRecord {

	private static EntityManager entityManager = JpaEntityManagerFactory.buildEntityManager();
	private static EntityTransaction transaction = JpaEntityManagerFactory.transaction();

	public static void main(String[] args) {
		//deleteStudent();
		//deleteStudentById(46);
		deleteStudentByIdQuery(47);
		
	}

	public static void deleteStudent() {
		Student student = entityManager.find(Student.class, (long) 45);
		transaction.begin();
		entityManager.remove(student);
		transaction.commit();
	}

	public static void deleteStudentById(long id) {
		Student student = entityManager.getReference(Student.class, id);
		transaction.begin();
		if (student != null)
			entityManager.remove(student);
		transaction.commit();
	}

	public static void deleteStudentByIdQuery(long id) {
		Query query = entityManager.createNamedQuery("StudentDetail.deleteByID");
		transaction.begin();
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
	}
}
