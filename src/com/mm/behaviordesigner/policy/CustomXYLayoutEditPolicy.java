package com.mm.behaviordesigner.policy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.mm.behaviordesigner.command.CreateCommand;
import com.mm.behaviordesigner.model.AbstractModel;

public class CustomXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		CreateCommand command = new CreateCommand();
		Rectangle constraint = (Rectangle) getConstraintFor(request);
		AbstractModel model = (AbstractModel) request.getNewObject();
		model.setConstraint(constraint);
		command.setContentModel(getHost().getModel());
		command.setModel(model);
		return command;
	}

}
