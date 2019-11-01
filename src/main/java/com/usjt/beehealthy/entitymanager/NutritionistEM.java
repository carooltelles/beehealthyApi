package com.usjt.beehealthy.entitymanager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.usjt.beehealthy.model.Nutritionist;

public class NutritionistEM {

	private static NutritionistEM instance;
	protected EntityManager entityManager;

	public static NutritionistEM getInstance() {
		if (instance == null) {
			instance = new NutritionistEM();
		}

		return instance;
	}

	public NutritionistEM() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("beehealthyPU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Nutritionist getById(final int id) {
		return entityManager.find(Nutritionist.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Nutritionist> findAll() {
		return entityManager.createQuery("FROM " + Nutritionist.class.getName()).getResultList();
	}

	public void persist(Nutritionist Nutritionist) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Nutritionist);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Nutritionist nutritionist) {
		Query query = entityManager.createQuery("UPDATE nutritionist SET specialization=?, crn=? ", Nutritionist.class);
		query.executeUpdate();
		
	}

	public void remove(Nutritionist Nutritionist) {
		try {
			entityManager.getTransaction().begin();
			Nutritionist = entityManager.find(Nutritionist.class, Nutritionist.getIduser());
			entityManager.remove(Nutritionist);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Nutritionist Nutritionist = getById(id);
			remove(Nutritionist);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}