package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.SwtBotHelper;

/**
 * Provide a simple to use frontend for the new wizard.
 * 
 * @author mboonk
 *
 */
public class NewWizardUiHelper extends WizardUiHelper {

	NewWizardUiHelper(SWTBot bot) {
		super(bot);
	}

	public TestCaseWizardUiHelper selectTestCase() {
		SwtBotHelper.selectInTree(bot.tree(), Strings.WIZARD_CATEGORY_GLOBALTESTER, Strings.WIZARD_ITEM_TESTCASE);
		next();
		return new TestCaseWizardUiHelper(bot);
	}

	public TestSpecificationWizardUiHelper selectTestSpecification(){
		SwtBotHelper.selectInTree(bot.tree(), Strings.WIZARD_CATEGORY_GLOBALTESTER, Strings.WIZARD_ITEM_TESTSPECIFICATION);
		next();
		return new TestSpecificationWizardUiHelper(bot);
	}

	public CardConfigWizardUiHelper selectCardConfiguration() {
		SwtBotHelper.selectInTree(bot.tree(), Strings.WIZARD_CATEGORY_GLOBALTESTER, Strings.WIZARD_ITEM_CARDCONFIG);
		next();
		return new CardConfigWizardUiHelper(bot);
	}
	
}
