/*
 *  Copyright © - 2013 LINKS Surveying. All rights reserved.
 */
package com.links.bms.model.product;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 * Entity class for area product.
 *
 * @author Sai Pradeep Dandem <sai@anahata-it.com.au>
 */
@Entity
@DiscriminatorValue(value = "AREA")
@Table(name = "areaproduct")
public class AreaProduct extends Product{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaProduct")
    private List<AreaVariation> variations = new ArrayList<>();

	public List<AreaVariation> getVariations() {
		return variations;
	}

	public void setVariations(List<AreaVariation> variations) {
		this.variations = variations;
	}
    
}
