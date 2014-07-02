package com.sai.jpa.mains;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sai.jpa.datagenerator.DataGenerator;
import com.sai.jpa.entities.Locality;

/**
 * Example to simply fetch the entity by name, if not found then persist in database.
 * 
 * @author sai.dandem
 *
 */
public class SimpleFetchAndPersistExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Open a database connection (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/General.odb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		// Ensuring to clear the table.
		tx.begin();
		em.createQuery("DELETE FROM Locality").executeUpdate();
		tx.commit();

		List<Locality> localities = DataGenerator.getLocalities();
		// Iterate through each locality to find.
		for (Locality locality : localities) {
			final CriteriaBuilder cb = em.getCriteriaBuilder();
			final CriteriaQuery<Locality> q = cb.createQuery(Locality.class);
			final Root<Locality> root = q.from(Locality.class);
			q.select(root);
			q.where(cb.equal(root.<String> get("name"), locality.getName()), cb.equal(root.<String> get("state"), locality.getState()));
			try {
				Locality l = em.createQuery(q).getSingleResult();
			} catch (NoResultException e) {
				// If no record is found then persisting the entity.
				tx.begin();
				em.persist(locality);
				tx.commit();
			}
		}

		// Fetching the details of Locality table and displaying for verification.
		final List<Locality> list = em.createQuery("SELECT FROM Locality").getResultList();
		for (Locality locality : list) {
			System.out.println(locality.getId() + " - " + locality.getName());
		}
	}
}
