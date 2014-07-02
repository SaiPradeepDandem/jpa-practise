/*
 *  Copyright © - 2013 LINKS Surveying. All rights reserved.
 */
package com.links.bms.model.product;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for product.
 * 
 * @author Sai Pradeep Dandem <sai@anahata-it.com.au>
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue(value = "PRODUCT")
@Table(name = "product")
public class Product extends Base implements Serializable, Activatable {
	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private String type;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@Basic(optional = false)
	@Column(name = "ACTIVE")
	private boolean active = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
