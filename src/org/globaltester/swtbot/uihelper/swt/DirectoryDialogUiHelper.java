package org.globaltester.swtbot.uihelper.swt;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.uihelper.DialogUiHelper;
import org.globaltester.swtbot.uihelper.UiHelper;

/**
 * Provide a simple to use frontend for the directory dialog.
 * 
 * @author mboonk
 *
 */
public class DirectoryDialogUiHelper extends DialogUiHelper {

	DirectoryDialogUiHelper(SWTBot bot) {
		super(bot);
	}

	public void setLocation(String path){
		bot.text().setText(path);
	}
	
	public void ok(){
		bot.button(Strings.BUTTONS_DIALOG_OK).click();
	}
}
