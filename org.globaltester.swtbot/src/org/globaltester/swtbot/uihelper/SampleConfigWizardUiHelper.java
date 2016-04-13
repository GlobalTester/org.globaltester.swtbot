package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.globaltester.swtbot.Strings;

/**
 * Provide a simple to use frontend for the sample configuration wizard.
 * 
 * @author mboonk
 *
 */
public class SampleConfigWizardUiHelper extends WizardUiHelper {

	protected SampleConfigWizardUiHelper(SWTBot bot) {
		super(bot);
	}
	
	public void setProjectName(String name){
		bot.text().setText(name);
	}
	
	public void setDescription(String description){
		next();
		bot.tabItem(Strings.TAB_ITEM_SAMPLECONFIG_GENERAL).activate();
		bot.text(1).setText(description);
		back();
	}
	
	public void setPin(String pin){
		next();
		bot.tabItem(Strings.TAB_ITEM_SAMPLECONFIG_PASSWORDS).activate();
		bot.text().setText(pin);
		back();
	}
	
	public void setMrz(String line1, String line2, String line3){
		next();
		bot.tabItem(Strings.TAB_ITEM_SAMPLECONFIG_ICAO9303).activate();
		bot.text(0).setText(line1);
		bot.text(1).setText(line2);
		bot.text(2).setText(line3);
		back();
	}
}
