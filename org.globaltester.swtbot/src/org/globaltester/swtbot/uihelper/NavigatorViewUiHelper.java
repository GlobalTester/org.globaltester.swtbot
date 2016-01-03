package org.globaltester.swtbot.uihelper;

import java.util.Arrays;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.SwtBotHelper;

/**
 * Provide a simple to use frontend for the navigator view.
 * 
 * @author mboonk
 *
 */
public class NavigatorViewUiHelper extends ViewUiHelper{

	protected NavigatorViewUiHelper(SWTBotView view) {
		super(view);
	}
	
	public void expandAndSelect(String ...items){
		SWTBotTreeItem item = bot.tree().expandNode(Arrays.copyOfRange(items, 0, items.length - 1));
		item.select(items[items.length-1]);
	}
	
	public void expandInNavigator(String ...strings ){
		bot.tree().expandNode(strings);
	}
	
	public TestCampaignEditorUiHelper openTestCampaign(String projectName){
		SWTBotView globalTesterNavigatorView = GlobalTesterUiHelper.getBot().viewByTitle(projectName);
		globalTesterNavigatorView.setFocus();
		expandAndSelect(projectName, Strings.FILENAME_TESTCAMPAIGN);
		bot.tree().contextMenu(Strings.CONTEXTMENU_ENTRY_OPEN).click();
		return new TestCampaignEditorUiHelper(GlobalTesterUiHelper.getBot().activeEditor());
	}
	
	public ExportWizardUiHelper openExportWizardByNavigatorContextMenu() {
		openWizardByNavigatorContextMenu(Strings.MENU_ENTRY_EXPORT, Strings.WIZARD_TITLE_EXPORT);
		
		SWTBot exportDialogBot = bot.shell(Strings.WIZARD_TITLE_EXPORT).bot();
		SwtBotHelper.selectInTree(exportDialogBot.tree(), Strings.WIZARD_CATEGORY_GLOBALTESTER, 0);

		return new ExportWizardUiHelper(exportDialogBot);
	}
	
	public ImportWizardUiHelper openImportWizardByNavigatorContextMenu() {
		openWizardByNavigatorContextMenu(Strings.MENU_ENTRY_IMPORT, Strings.WIZARD_TITLE_IMPORT);	
		return new ImportWizardUiHelper(bot.shell(Strings.WIZARD_TITLE_IMPORT).bot());
	}
	
	private void openWizardByNavigatorContextMenu(String menuEntry, String wizardTitle){
		//get the tree view widget of the GT View
		SWTBotTree navigatorTree = bot.tree();
		//Select Import
		SWTBotMenu contextMenu = navigatorTree.contextMenu(menuEntry);
		contextMenu.click();
		bot.waitUntil(Conditions.shellIsActive(wizardTitle), 5000, 500);
	}
}
