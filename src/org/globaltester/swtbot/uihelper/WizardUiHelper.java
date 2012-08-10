package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.globaltester.swtbot.Strings;


/**
 * Provide generic methods for wizards.
 * 
 * @author mboonk
 *
 */
public abstract class WizardUiHelper extends UiHelper{

	protected WizardUiHelper(SWTBot bot) {
		super(bot);
	}
	
	/**
	 * Simulate a click on the "Finish" button
	 */
	public final void finish(){
		SWTBotShell shell = bot.activeShell();
		bot.button(Strings.WIZARD_BUTTON_FINISH).click();
		finishingActions();
		bot.waitUntil(Conditions.shellCloses(shell));
	}
	
	/**
	 * Override this method if you want to execute code between click on "Finish"
	 * and the actual closing of the wizard shell
	 */
	protected void finishingActions(){
		
	}
	
	/**
	 * Simulate a click on the "Cancel" button
	 */
	public void cancel() {
		bot.button(Strings.WIZARD_BUTTON_CANCEL).click();
	}
	
	/**
	 * Simulate a click on the "Next" button
	 */
	public void next(){
		bot.button(Strings.WIZARD_BUTTON_NEXT).click();
	}
	
	/**
	 * Simulate a click on the "Back" button
	 */
	public void back() {
		bot.button(Strings.WIZARD_BUTTON_BACK).click();
	}
}
