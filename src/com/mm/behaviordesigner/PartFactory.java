package com.mm.behaviordesigner;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.mm.behaviordesigner.model.CompositeModel;
import com.mm.behaviordesigner.model.ContentModel;
import com.mm.behaviordesigner.model.EntryModel;
import com.mm.behaviordesigner.part.CompositeEditPar;
import com.mm.behaviordesigner.part.ContentEditPar;
import com.mm.behaviordesigner.part.EntryEditPar;

public class PartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		
		EditPart part = this.getPartForElement(model);
		part.setModel(model);
		return part;
	}
	
	private EditPart getPartForElement(Object model) {
		if(model instanceof ContentModel) {
			return new ContentEditPar();
			
		}else if(model instanceof EntryModel) {
			return new EntryEditPar();
			
		}else if(model instanceof CompositeModel) {
			return new CompositeEditPar();
			
		}
			
		
		throw new RuntimeException("Can't create part  from model element");
		
	}

}
