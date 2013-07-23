//========================================================================
//
//File:      $RCSfile: AttributeChangeModelDelta.java,v $
//Version:   $Revision: 1.12 $
//Modified:  $Date: 2013/01/10 22:54:10 $
//
//(c) Copyright 2005-2013 by Mentor Graphics Corp. All rights reserved.
//
//========================================================================
//This document contains information proprietary and confidential to
//Mentor Graphics Corp., and is not for external distribution.
//======================================================================== 

package com.mentor.nucleus.bp.core.common;


public class AttributeChangeModelDelta extends BaseModelDelta {

	private String attributeName = null;
	private Object newValue;
	private Object oldValue;
	private boolean persistenceRelatedChange;
	/**
	 * @param eventType
	 * @param aModelElement
	 */
	public AttributeChangeModelDelta(int eventType, ModelElement modelElement, String attribName, Object oldValue, Object newValue,boolean persistenceRelatedChange) {
		super(eventType, modelElement);
		attributeName = attribName;
		this.newValue = newValue;
		this.oldValue = oldValue;
        this.persistenceRelatedChange=persistenceRelatedChange;
	}
	
	public String getAttributeName(){
		return attributeName;
	}
		
	/**
	 * @return Returns the newValue.
	 */
	public Object getNewValue() {
		return newValue;
	}
	/**
	 * @param newValue the new value to set.
	 */
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}
	/**
	 * @return Returns the oldValue.
	 */
	public Object getOldValue() {
		return oldValue;
	}
	/**
	 * @return Returns true if the delta is on the same attribute.
	 */
	public boolean equals(Object o) {
		if (o instanceof AttributeChangeModelDelta) {
			AttributeChangeModelDelta acd = (AttributeChangeModelDelta)o;
			return ( attributeName.equals(acd.attributeName) &&
					getModelElement().equals(acd.getModelElement())); 
		}
		return false;
	}

    public boolean isPersistenceRelatedChange() {
        return persistenceRelatedChange;
    }

    public void setPersistenceRelatedChange(boolean persistenceRelatedChange) {
        this.persistenceRelatedChange = persistenceRelatedChange;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     * 
     * Is overridden to correlate with the above equals() override, so that 
     * two distinct instances that are equal will return the same hashcode,
     * per the contract of hashCode(). 
     */
    public int hashCode()
    {
        return attributeName.hashCode() + getModelElement().hashCode();
    }
}
