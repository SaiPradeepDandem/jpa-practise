package com.sai.jpa.mains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.links.bms.model.product.AreaProduct;
import com.links.bms.model.product.AreaType;
import com.links.bms.model.product.AreaVariation;
import com.links.bms.model.product.Category;
import com.links.bms.model.product.Product;
import com.links.bms.model.product.ProductChoices;
import com.links.bms.model.product.QuantityProduct;

public class ObjectDBSample2 {

	public static void main(String[] args) {
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/products.odb");
		EntityManager em = emf.createEntityManager();

		// Store 1000 Point objects in the database:
		em.getTransaction().begin();
		for (int i = 0; i < 1; i++) {
			Category cat = new Category();
			cat.setName("Category 1");
			
			Product pro =new Product();
			pro.setActive(true);
			pro.setCategory(cat);
			pro.setName("Product 1");
			pro.setType("Home");
			
			QuantityProduct qp =new QuantityProduct();
			qp.setActive(true);
			qp.setCategory(cat);
			qp.setName("Qunt Product 1");
			qp.setType("Survey");
			qp.setMinQuantity(2);
			
			
			AreaProduct ap =new AreaProduct();
			ap.setActive(true);
			ap.setCategory(cat);
			ap.setName("Area Product 1");
			ap.setType("Survey");
			
			AreaVariation var = new AreaVariation();
			var.setActive(true);
			var.setAreaType(AreaType.ESTABLISHED);
			var.setFromSqm(1000L);
			var.setToSqm(2000L);
			var.setAreaProduct(ap);
			
			List<AreaVariation> vars = new ArrayList<>();
			vars.add(var);
			ap.setVariations(vars);
			
			List<Product> prods = new ArrayList<>();
			prods.add(qp);
			prods.add(ap);
			
			ProductChoices choices = new ProductChoices();
			choices.setActive(true);
			choices.setName("Choice 1");
			choices.setCategory(cat);
			choices.setProducts(prods);
			
			List<ProductChoices> proChoic = new ArrayList<>();
			proChoic.add(choices);
			cat.setProductchoices(proChoic);
			
			List<Product> prods2 = new ArrayList<>();
			prods2.add(pro);
			cat.setProducts(prods2);
			
			em.persist(cat);
		}
		em.getTransaction().commit();

		// Find the number of Point objects in the database:
		Query q1 = em.createQuery("SELECT COUNT(p) FROM Category p");
		System.out.println("Total Points: " + q1.getSingleResult());

		// Close the database connection:
		em.close();
		emf.close();
	}

}
