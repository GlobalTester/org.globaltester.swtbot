package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;

/**
 * Provide a simple to use frontend for the test specification wizard.
 * 
 * @author mboonk
 *
 */
public class TestSpecificationWizardUiHelper extends WizardUiHelper{
	TestSpecificationWizardUiHelper(SWTBot bot) {
		super(bot);
	}

	public void setProjectName(String name){
		bot.text().setText(name);
	}
}
