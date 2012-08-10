package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

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

	public void close(){
		view.close();
	}
}
