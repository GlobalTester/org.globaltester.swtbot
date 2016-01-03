package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.globaltester.swtbot.Strings;

/**
 * Provide a simple to use frontend for the card configuration dialog.
 * 
 * @author mboonk
 *
 */
public class CardConfigDialogUiHelper extends DialogUiHelper {

	CardConfigDialogUiHelper(SWTBot bot) {
		super(bot);
	}
	
	public String [] getConfigs(){
		return bot.comboBox().items();
	}
	
	public void selectItem(String item){
		bot.comboBox().setSelection(item);
	}

	public CardConfigWizardUiHelper createNewConfig(){
		bot.button(Strings.BUTTONS_CARDCONFIG_NEW).click();
		bot.waitUntil(Conditions.shellIsActive(Strings.WIZARD_TITLE_CARDCONFIG));
		return new CardConfigWizardUiHelper(bot.activeShell().bot());
	}
}
