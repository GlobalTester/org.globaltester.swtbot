package org.globaltester.swtbot.uihelper;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarDropDownButton;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.SwtBotHelper;
import org.globaltester.swtbot.conditions.AnyShellIsActive;
import org.globaltester.junit.*;

/**
 * Provides methods for using the GlobalTester application.
 * 
 * @author mboonk
 *
 */
public class GlobalTesterUiHelper {
	
	private static final SWTWorkbenchBot bot = new SWTWorkbenchBot();
	
	/**
	 * Tries to restore the default perspective and close all unneeded dialogs, shells, views etc.
	 * Additionally the workspace is emptied.
	 * 
	 * @throws CoreException
	 */
	public static void init() throws CoreException{
		bot.waitUntil(Conditions.shellIsActive(Strings.WORKBENCH_TITLE));
		SwtBotHelper.resetWorkbenchState(bot);
		SwtBotHelper.resetSpeed();
		JUnitHelper.emptyWorkspace();
	}
	
	public static NavigatorViewUiHelper focusNavigatorView(){
		SWTBotView globalTesterNavigatorView = bot.viewByTitle(Strings.VIEW_NAVIGATOR);
		globalTesterNavigatorView.setFocus();
		return new NavigatorViewUiHelper(globalTesterNavigatorView);
	}
	
	public static void createAndStartTestCampaignByToolBar(){
//		SWTBotToolbarDropDownButton button = bot.toolbarDropDownButton(Strings.TOOLBAR_TOOLTIP_CREATE_AND_EXECUTE);
		SWTBotToolbarDropDownButton button = bot.toolbarDropDownButton(1);
		button.click();
		bot.waitUntil(new AnyShellIsActive(Strings.DIALOG_TITLE_CARDCONFIG, Strings.DIALOG_TITLE_TEST_EXECUTION));
		SWTBotShell shell = bot.activeShell();
		if (shell != null && shell.getText().equals(Strings.DIALOG_TITLE_CARDCONFIG)){
			shell.bot().button(Strings.BUTTONS_CARDCONFIG_OK).click();
		}
		
	}
	public static CardConfigDialogUiHelper createAndStartTestCampaignByToolBarOtherCardConfig(){
//		SWTBotToolbarDropDownButton button = bot.toolbarDropDownButton(Strings.TOOLBAR_TOOLTIP_CREATE_AND_EXECUTE);
		SWTBotToolbarDropDownButton button = bot.toolbarDropDownButton(1);
		button.click();
		bot.waitUntil(Conditions.shellIsActive(Strings.DIALOG_TITLE_CARDCONFIG));
		SWTBotShell dialog = bot.shell(Strings.DIALOG_TITLE_CARDCONFIG);
		return new CardConfigDialogUiHelper(dialog.bot());
	}
	
	public static ExportWizardUiHelper openExportWizardByMenu(){
		openWizardByMenu(Strings.WIZARD_TITLE_EXPORT, Strings.MENU_ENTRY_EXPORT);
		
		SWTBot wizardBot = bot.shell(Strings.WIZARD_TITLE_EXPORT).bot();
		wizardBot.tree().getTreeItem(Strings.WIZARD_CATEGORY_GLOBALTESTER).expand()
				.select(Strings.WIZARD_ITEM_EXPORT);
		bot.button(Strings.WIZARD_BUTTON_NEXT).click();
		bot.waitUntil(Conditions.shellIsActive(Strings.WIZARD_TITLE_REAL_EXPORT), 5000, 500);
		return new ExportWizardUiHelper(wizardBot);
	}
	
	public static ImportWizardUiHelper openImportWizardByMenu(){
		openWizardByMenu(Strings.WIZARD_TITLE_IMPORT, Strings.MENU_ENTRY_IMPORT);

		SWTBot wizardBot = bot.shell(Strings.WIZARD_TITLE_IMPORT).bot();
		wizardBot.tree().getTreeItem(Strings.WIZARD_CATEGORY_GLOBALTESTER).expand()
				.select(Strings.WIZARD_ITEM_IMPORT);
		bot.button(Strings.WIZARD_BUTTON_NEXT).click();
		bot.waitUntil(Conditions.shellIsActive(Strings.WIZARD_TITLE_REAL_IMPORT), 5000, 500);
		return new ImportWizardUiHelper(wizardBot);
	}
	
	private static void openWizardByMenu(String wizardTitle, String menuEntry){
		bot.menu(Strings.MENU_FILE).menu(menuEntry).click();
		bot.waitUntil(Conditions.shellIsActive(wizardTitle), 5000, 500);
	}

	public static NewWizardUiHelper openNewWizardByMenu() {
		openWizardByMenu(Strings.WIZARD_TITLE_NEW, Strings.MENU_ENTRY_NEW);
		bot.waitUntil(Conditions.shellIsActive(Strings.WIZARD_TITLE_NEW), 5000, 500);
		return new NewWizardUiHelper(bot.shell(Strings.WIZARD_TITLE_NEW).bot());
	}
	
	public static TestCampaignEditorUiHelper focusTestCampaignEditor(){
		return new TestCampaignEditorUiHelper(bot.editorById(Strings.EDITOR_ID_TESTCAMPAIGN)); 
	}

	public static LogFileEditorUiHelper focusLogFileEditor() {
		return new LogFileEditorUiHelper(bot.editorById(Strings.EDITOR_ID_LOGFILE));
	}
	
	public static SWTWorkbenchBot getBot() {
		return bot;
	}
}
