/*
 *  Copyright © - 2013 LINKS Surveying. All rights reserved.
 */
package com.links.bms.model.product;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

/**
 * Entity class for area variations.
 *
 * @author Sai Pradeep Dandem <sai@anahata-it.com.au>
 */
@Entity
@Table(name = "areavariation")
public class AreaVariation extends Base implements Serializable, Activatable {
    @Column(name = "FROMSQM")
    private Long fromSqm;

    @Column(name = "TOSQM")
    private Long toSqm;

    @Basic(optional = false)
    @NotNull
    @Column(name = "AREATYPE")
    private AreaType areaType;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "AREAPRODUCT_ID")
    private AreaProduct areaProduct;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVE")
    private boolean active = true;

	public Long getFromSqm() {
		return fromSqm;
	}

	public void setFromSqm(Long fromSqm) {
		this.fromSqm = fromSqm;
	}

	public Long getToSqm() {
		return toSqm;
	}

	public void setToSqm(Long toSqm) {
		this.toSqm = toSqm;
	}

	public AreaType getAreaType() {
		return areaType;
	}

	public void setAreaType(AreaType areaType) {
		this.areaType = areaType;
	}

	public AreaProduct getAreaProduct() {
		return areaProduct;
	}

	public void setAreaProduct(AreaProduct areaProduct) {
		this.areaProduct = areaProduct;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
    
    
}
