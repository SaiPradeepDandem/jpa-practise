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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

/**
 * Entity class for the product choices.
 *
 * @author Sai Pradeep Dandem <sai@anahata-it.com.au>
 */
@Entity
@Table(name = "productchoices")
public class ProductChoices extends Base implements Serializable, Activatable {

    @Column(name = "NAME")
    private String name;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
        
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productchoices")
    private List<Product> products = new ArrayList<>();
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVE")
    private boolean active = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
    
    
}
