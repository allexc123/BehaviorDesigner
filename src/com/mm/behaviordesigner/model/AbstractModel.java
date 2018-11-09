package com.mm.behaviordesigner.model;

import org.eclipse.draw2d.geometry.Rectangle;

public abstract class AbstractModel {
	private Rectangle constraint;

	public Rectangle getConstraint() {
		return constraint;
	}

	public void setConstraint(Rectangle constraint) {
		this.constraint = constraint;
	}
	
}
