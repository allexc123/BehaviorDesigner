package com.mm.behaviordesigner.part;



import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.mm.behaviordesigner.model.AbstractModel;

public class CompositeEditPar extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		Label label = new Label();
		label.setText("AVSWWWW");
		label.setBorder(new CompoundBorder(new LineBorder(), new MarginBorder(3)));
		label.setBackgroundColor(ColorConstants.orange);
		label.setOpaque(true);
		return label;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

	}
	@Override
	protected void refreshVisuals() {
		Rectangle constraint = ((AbstractModel) getModel()).getConstraint();
		((GraphicalEditPart) getParent()).setLayoutConstraint(this,getFigure(), constraint);
	}

}
