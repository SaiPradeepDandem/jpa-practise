package com.links.bms.model.product;

/**
 * Identifies a domain object as being able to be set as active and inactive.
 * 
 * @author Robert Nagajek <robert@anahata-it.com.au>
 */
public interface Activatable {
    /**
     * Determine if the object is active.
     * 
     * @return true if active, false if not.
     */
    public boolean isActive();
    
    /**
     * Set the active status of this object.
     * 
     * @param active The active status.
     */
    public void setActive(boolean active);
}
