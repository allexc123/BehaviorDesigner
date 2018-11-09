package com.mm.behaviordesigner.command;

import org.eclipse.gef.commands.Command;

import com.mm.behaviordesigner.model.AbstractModel;
import com.mm.behaviordesigner.model.ContentModel;

public class CreateCommand extends Command {

	private ContentModel contentModel;
	private AbstractModel model;
	@Override
	public void execute() {
		contentModel.addChild(model);
	}
	public ContentModel getContentModel() {
		return contentModel;
	}
	public void setContentModel(Object contentModel) {
		this.contentModel = (ContentModel) contentModel;
	}
	public AbstractModel getModel() {
		return model;
	}
	public void setModel(Object model) {
		this.model = (AbstractModel) model;
	}

	
	
}
