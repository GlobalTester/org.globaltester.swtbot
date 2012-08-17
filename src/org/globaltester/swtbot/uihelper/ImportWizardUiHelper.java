package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.SwtBotHelper;

/**
 * Provide a simple to use frontend for the import wizard.
 * 
 * @author mboonk
 *
 */
public class ImportWizardUiHelper extends WizardUiHelper{

	ImportWizardUiHelper(SWTBot bot) {
		super(bot);
	}
	
	public TestSpecificationImportWizardUiHelper openTestSpecificationImportWizard(){
		SwtBotHelper.selectInTree(bot.tree(), Strings.WIZARD_CATEGORY_GLOBALTESTER, Strings.WIZARD_ITEM_IMPORT);
		next();
		return new TestSpecificationImportWizardUiHelper(bot.shell(Strings.WIZARD_TITLE_TESTSPECIFICATION_IMPORT).bot());
	}
}
