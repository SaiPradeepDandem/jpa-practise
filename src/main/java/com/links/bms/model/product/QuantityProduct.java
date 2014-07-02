/*
 *  Copyright © - 2013 LINKS Surveying. All rights reserved.
 */

package com.links.bms.model.product;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Entity class for quantity product.
 *
 * @author Sai Pradeep Dandem <sai@anahata-it.com.au>
 */
@Entity
@DiscriminatorValue(value = "QUANTITY")
@Table(name = "quantityproduct")
public class QuantityProduct  extends Product{
    @Column(name = "MINQUANTITY")
    private int minQuantity;

	public int getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}
    
    
}
