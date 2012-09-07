package org.globaltester.swtbot.uihelper;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;

/**
 * Provide generic methods for views.
 * 
 * @author mboonk
 *
 */
public class ViewUiHelper extends UiHelper {

	protected SWTBotView view;
	
	protected ViewUiHelper(SWTBotView view) {
		super(view.bot());
		this.view = view;
	}

	@Override
	public void captureScreenshot(final String fileName) {
		final Composite comp = (Composite) view.getWidget();
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
							if (item.getText().equals(view.getTitle())){
								Point displayRelative = folder.toDisplay(Display.getCurrent().getBounds().x, Display.getCurrent().getBounds().y);
								bounds = folder.getBounds();
								bounds.y += displayRelative.y;
								bounds.x += displayRelative.x;
							}
						}
					}
				}
				System.out.println(bounds);
				SWTUtils.captureScreenshot(fileName, bounds);
			}
		});
		
	};
	
	public void close(){
		view.close();
	}
}
