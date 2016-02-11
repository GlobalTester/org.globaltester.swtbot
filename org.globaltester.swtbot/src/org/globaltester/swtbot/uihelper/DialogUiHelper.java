package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
/**
 * Provide generic methods for dialogs.
 * 
 * @author mboonk
 *
 */
public class DialogUiHelper extends UiHelper {

	SWTBotShell shell;
	
	protected DialogUiHelper(SWTBot bot) {
		super(bot);
		shell = bot.activeShell();
	}
	
	public void close(){
		shell.close();
	}

}
