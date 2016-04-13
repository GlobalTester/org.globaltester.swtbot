package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.globaltester.swtbot.Strings;

/**
 * Provide a simple to use frontend for the Sample configuration dialog.
 * 
 * @author mboonk
 *
 */
public class SampleConfigDialogUiHelper extends DialogUiHelper {

	SampleConfigDialogUiHelper(SWTBot bot) {
		super(bot);
	}
	
	public String [] getConfigs(){
		return bot.comboBox().items();
	}
	
	public void selectItem(String item){
		bot.comboBox().setSelection(item);
	}

	public SampleConfigWizardUiHelper createNewConfig(){
		bot.button(Strings.BUTTONS_SAMPLECONFIG_NEW).click();
		bot.waitUntil(Conditions.shellIsActive(Strings.WIZARD_TITLE_SAMPLECONFIG));
		return new SampleConfigWizardUiHelper(bot.activeShell().bot());
	}
}
