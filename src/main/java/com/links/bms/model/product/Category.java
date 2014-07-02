/*
 *  Copyright © - 2013 LINKS Surveying. All rights reserved.
 */
package com.links.bms.model.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class for category.
 * 
 * @author Sai Pradeep Dandem <sai@anahata-it.com.au>
 */
@Entity
@Table(name = "category")
public class Category extends Base implements Serializable, Activatable {
	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> products = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<ProductChoices> productchoices = new ArrayList<>();

	@Basic(optional = false)
	@Column(name = "ACTIVE")
	private boolean active = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<ProductChoices> getProductchoices() {
		return productchoices;
	}

	public void setProductchoices(List<ProductChoices> productchoices) {
		this.productchoices = productchoices;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
