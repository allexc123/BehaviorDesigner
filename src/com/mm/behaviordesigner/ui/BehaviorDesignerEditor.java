package com.mm.behaviordesigner.ui;

import org.eclipse.core.runtime.IProgressMonitor;
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
import com.mm.behaviordesigner.model.SequenceModel;

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
		
		viewer.setEditPartFactory( new PartFactory());
	}

	@Override
	protected void initializeGraphicalViewer() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	protected PaletteRoot getPaletteRoot() {
		// (1)首先要创建一个palette的route
		PaletteRoot root = new PaletteRoot();
		
		PaletteDrawer drawer = new PaletteDrawer("Composites");
		ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(GlobalKey.PLUGIN_ID, "icons/alt_window16.gif");
		CreationToolEntry creationEntry = new CreationToolEntry("Sequence", "创建sequence模型", new SimpleFactory(SequenceModel.class), descriptor, descriptor);
		drawer.add(creationEntry);
		
		root.add(drawer);
		return root;
	}

	

	@Override
	public void doSave(IProgressMonitor arg0) {
		// TODO Auto-generated method stub
		
	}

}
