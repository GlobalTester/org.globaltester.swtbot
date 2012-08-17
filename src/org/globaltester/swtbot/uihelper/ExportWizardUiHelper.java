package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.SwtBotHelper;

/**
 * Provide a simple to use frontend for the export wizard.
 * 
 * @author mboonk
 *
 */
public class ExportWizardUiHelper extends WizardUiHelper{

	ExportWizardUiHelper(SWTBot bot) {
		super(bot);
	}

	public TestSpecificationExportWizardUiHelper openTestSpecificationExportWizard(){
		SwtBotHelper.selectInTree(bot.tree(), Strings.WIZARD_CATEGORY_GLOBALTESTER, Strings.WIZARD_ITEM_EXPORT);
		next();
		return new TestSpecificationExportWizardUiHelper(bot.shell(Strings.WIZARD_TITLE_TESTSPECIFICATION_EXPORT).bot());
	}
}
