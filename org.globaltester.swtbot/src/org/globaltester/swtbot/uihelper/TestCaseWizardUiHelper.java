package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;

/**
 * Provide a simple to use frontend for the test case wizard.
 * 
 * @author mboonk
 *
 */
public class TestCaseWizardUiHelper extends WizardUiHelper{

	protected TestCaseWizardUiHelper(SWTBot bot) {
		super(bot);
	}

	public void selectFolder(String projectName) {
		bot.text(0).setText(projectName);
	}

}
