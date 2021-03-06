package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.globaltester.swtbot.Strings;

public class TestSpecificationImportWizardUiHelper extends WizardUiHelper {

	protected TestSpecificationImportWizardUiHelper(SWTBot bot) {
		super(bot);
	}

	public void setProjectName(String name){
		bot.text().setText(name);
	}
	
	public String[] getProjects() {
		return bot.list().getItems();

	}
	
	public void selectProject(String name){
		bot.list().select(name);
	}

	@Override
	public void finishingActions() {
		bot.waitUntil(Conditions.shellIsActive(Strings.DIALOG_TITLE_IMPORT));
		bot.shell(Strings.DIALOG_TITLE_IMPORT).bot().button().click();
	}
}
