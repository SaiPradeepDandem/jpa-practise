package com.links.bms.model.product;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The base entity model for Yam model classes.
 * 
 * @author Robert Nagajek <robert@anahata-it.com.au>
 */
@MappedSuperclass
public abstract class Base implements Serializable {
	@Id
	@GeneratedValue
	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final Base other = (Base) obj;

		if (id == null || other.id == null) {
			return false;
		}

		return id.equals(other.id);
	}

	@Override
	public int hashCode() {
		if (id == null) {
			return super.hashCode();
		}

		int hash = 7;
		hash = 97 * hash + id.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": id=" + id + " ref=" + System.identityHashCode(this);
	}
}
