package com.usjt.beehealthy.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.usjt.beehealthy.model.Nutritionist;

public class NutricionistJpaDAO {
	
	protected EntityManager entityManager;
	
	public NutricionistJpaDAO() {
        entityManager = getEntityManager();
      }
	
	
	private EntityManager getEntityManager() {
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory("beehealthyPU");
        if (entityManager == null) {
          entityManager = factory.createEntityManager();
        }
 
        return entityManager;
       }
	
	public void merge(Nutritionist n) {
		try {
			entityManager.find(Nutritionist.class, n.getIduser());
			entityManager.merge(n);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
