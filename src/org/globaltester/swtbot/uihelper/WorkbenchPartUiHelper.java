package org.globaltester.swtbot.uihelper;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.ui.IWorkbenchPartReference;
import org.hamcrest.Matchers;

public class WorkbenchPartUiHelper extends UiHelper {
	protected IWorkbenchPartReference part;
	
	
	//TODO: MBK combine both constructors 
	protected WorkbenchPartUiHelper(SWTBotEditor editor) {
		super(editor.bot());
		this.part = editor.getReference();
	}
	
	public WorkbenchPartUiHelper(SWTBotView view) {
		super(view.bot());
		this.part = view.getReference();
	}

	@Override
	public void captureScreenshot(final String fileName) {
		final Composite comp = bot.widget(Matchers.any(Composite.class));
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				Rectangle bounds = null;
				Control [] children = comp.getParent().getChildren();
				for (Control c : children){
					if (c instanceof CTabFolder){
						CTabFolder folder = ((CTabFolder) c);
						CTabItem [] items = folder.getItems();
						for (CTabItem item : items){
							if (item.getText().equals(part.getTitle())){
								Point displayRelative = folder.toDisplay(Display.getCurrent().getBounds().x, Display.getCurrent().getBounds().y);
								bounds = folder.getBounds();
								bounds.y += displayRelative.y;
								bounds.x += displayRelative.x;
							}
						}
					}
				}
				SWTUtils.captureScreenshot(fileName, bounds);
			}
		});
		
	};

}
