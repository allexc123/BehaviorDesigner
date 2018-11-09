package com.mm.behaviordesigner.part;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.mm.behaviordesigner.model.ContentModel;
import com.mm.behaviordesigner.policy.CustomXYLayoutEditPolicy;

public class ContentEditPar extends AbstractGraphicalEditPart implements PropertyChangeListener{

	@Override
	protected IFigure createFigure() {
		Layer layer = new Layer();
		layer.setLayoutManager(new XYLayout());
		return layer;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CustomXYLayoutEditPolicy());

	}

	@Override
	protected List getModelChildren() {
		return ((ContentModel)getModel()).getChildren();
	}
	
	

	@Override
	public void activate() {
		super.activate();
		((ContentModel)getModel()).addPropertyChangeListener(this);
	}

	@Override
	public void deactivate() {
		super.deactivate();
		((ContentModel)getModel()).removePropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getPropertyName().equals(ContentModel.P_CHILDREN)) {
			refreshChildren();
		}
		
	}
	
	

}
