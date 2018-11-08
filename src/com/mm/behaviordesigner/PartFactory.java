package com.mm.behaviordesigner;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.mm.behaviordesigner.model.SequenceModel;
import com.mm.behaviordesigner.part.SequenceEditPar;

public class PartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		
		EditPart part = this.getPartForElement(model);
		part.setModel(model);
		return part;
	}
	
	private EditPart getPartForElement(Object model) {
		if(model instanceof SequenceModel) {
			return new SequenceEditPar();
			
		}
			
		
		throw new RuntimeException("Can't create part  from model element");
		
	}

}
