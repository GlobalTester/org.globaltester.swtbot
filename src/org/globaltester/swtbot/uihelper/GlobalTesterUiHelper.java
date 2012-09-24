package org.globaltester.swtbot.uihelper;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarDropDownButton;
import org.globaltester.junit.JUnitHelper;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.SwtBotHelper;
import org.globaltester.swtbot.conditions.AnyShellIsActive;

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
		SwtBotHelper.setUsKeyboardLayout();
		JUnitHelper.emptyWorkspace();
	}
	
	private static SWTBotView focusView(String title){
		SWTBotView view = bot.viewByTitle(title);
		view.setFocus();
		view.show();
		return view;
	}
	
	public static NavigatorViewUiHelper focusNavigatorView(){
		return new NavigatorViewUiHelper(focusView(Strings.VIEW_NAVIGATOR));
	}
	
	public static ScshViewUiHelper focusScshView(){
		return new ScshViewUiHelper(focusView(Strings.VIEW_SCSH));
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
		return new ExportWizardUiHelper(bot.shell(Strings.WIZARD_TITLE_EXPORT).bot());
	}
	
	public static ImportWizardUiHelper openImportWizardByMenu(){
		openWizardByMenu(Strings.WIZARD_TITLE_IMPORT, Strings.MENU_ENTRY_IMPORT);
		return new ImportWizardUiHelper(bot.shell(Strings.WIZARD_TITLE_IMPORT).bot());
	}
	
	public static AboutDialogUiHelper openAboutDialog(){
		clickMenuEntry(Strings.MENU_HELP, Strings.MENU_ENTRY_ABOUT);
		bot.waitUntil(Conditions.shellIsActive(Strings.DIALOG_TITLE_ABOUT), 5000, 500);
		return new AboutDialogUiHelper(bot.shell(Strings.DIALOG_TITLE_ABOUT).bot());
	}
	
	private static void clickMenuEntry(String... path){
		SWTBotMenu menu = bot.menu(path[0]);
		for (int i = 1; i < path.length; i++){
			menu = menu.menu(path[i]);
		}
		menu.click();
	}
	
	private static void openWizardByMenu(String wizardTitle, String menuEntry){
		clickMenuEntry(Strings.MENU_FILE, menuEntry);
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
	
	/**
	 * Capture a screenshot of the GlobalTester workbench.
	 * 
	 * @param fileName
	 */
	public static void captureScreenshot(String fileName){
		SWTUtils.captureScreenshot(fileName, bot.shell(Strings.WORKBENCH_TITLE).widget);
	}
	
	public static void captureScreenshot(String fileName, Rectangle bounds){
		SWTUtils.captureScreenshot(fileName, bounds);
	}
	
	public static SWTWorkbenchBot getBot() {
		return bot;
	}
}
