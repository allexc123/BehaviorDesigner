package com.mm.behaviordesigner.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ContentModel {
	
	public static final String P_CHILDREN="_children";
	
	private PropertyChangeSupport listeners = new PropertyChangeSupport(this);
	
	private List<Object> children = new ArrayList<>();

	public List<Object> getChildren() {
		return children;
	}

	public void addChild(Object child) {
		this.children.add(child);
		firePropertyChange(P_CHILDREN, null, null);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.removePropertyChangeListener(listener);
	}
	
	public void firePropertyChange(String propName,Object oldValue,Object newValue)
    {
        listeners.firePropertyChange(propName, oldValue, newValue);
    }

}
