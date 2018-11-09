package com.mm.behaviordesigner.ui;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.mm.behaviordesigner.PartFactory;
import com.mm.behaviordesigner.helper.GlobalKey;
import com.mm.behaviordesigner.helper.IImageKey;
import com.mm.behaviordesigner.model.CompositeModel;
import com.mm.behaviordesigner.model.ContentModel;
import com.mm.behaviordesigner.model.EntryModel;

public class BehaviorDesignerEditor extends GraphicalEditorWithPalette{
	
	public BehaviorDesignerEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected void createGraphicalViewer(Composite parent) {
//		RulerComposite rulerComposite = new RulerComposite(parent, SWT.NONE);
//		rulerComposite.setGraphicalViewer((ScrollingGraphicalViewer)getGraphicalViewer());
		super.createGraphicalViewer(parent);	
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		
		GraphicalViewer viewer  = getGraphicalViewer();
		
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, true);
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);
		
		viewer.setEditPartFactory(new PartFactory());
	}

	@Override
	protected void initializeGraphicalViewer() {
		ContentModel parent = new ContentModel();
		
		EntryModel entryModel = new EntryModel();
		entryModel.setConstraint(new Rectangle(350, 50, -1, -1));
		
		parent.addChild(entryModel);
		
		getGraphicalViewer().setContents(parent);
		
	}
	

	@Override
	protected PaletteRoot getPaletteRoot() {
		// (1)首先要创建一个palette的route
		PaletteRoot root = new PaletteRoot();
		
		PaletteDrawer drawer = new PaletteDrawer("Composites Node");
		//Sequence
		ImageDescriptor sequenceDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(GlobalKey.PLUGIN_ID, IImageKey.jiantou);
		CreationToolEntry sequenceEntry = new CreationToolEntry("Sequence", "创建sequence模型", new SimpleFactory(CompositeModel.class), sequenceDescriptor, sequenceDescriptor);
		drawer.add(sequenceEntry);
		//select
		ImageDescriptor selectorDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(GlobalKey.PLUGIN_ID, IImageKey.mergeLine);
		CreationToolEntry selectorEntry = new CreationToolEntry("Selector", "创建Selector模型", new SimpleFactory(CompositeModel.class), selectorDescriptor, selectorDescriptor);
		drawer.add(selectorEntry);
		
		root.add(drawer);
		return root;
	}

	

	@Override
	public void doSave(IProgressMonitor arg0) {
		// TODO Auto-generated method stub
		
	}

}
