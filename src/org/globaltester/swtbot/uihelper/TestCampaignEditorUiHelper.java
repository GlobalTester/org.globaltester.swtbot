package org.globaltester.swtbot.uihelper;

import java.io.File;

import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.globaltester.swtbot.Strings;

/**
 * Provide a simple to use frontend for the test campaign editor.
 * 
 * @author mboonk
 *
 */
public class TestCampaignEditorUiHelper extends EditorUiHelper {

	TestCampaignEditorUiHelper(SWTBotEditor editor) {
		super(editor);
	}
	
	public void setSpecificationName(String name){
		bot.text(0).setText(name);
	}
	
	public void setSpecificationVersion(String version){
		bot.text(1).setText(version);
	}
	
	public void historyBegin(){
		bot.button(Strings.BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_BEGIN).click();
	}
	
	public void historyEnd(){
		bot.button(Strings.BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_END).click();
	}
	
	public void historyBack(){
		bot.button(Strings.BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_BACK).click();
	}
	
	public void historyNext(){
		bot.button(Strings.BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_NEXT).click();
	}
	
	public String [] getExecutions(){
		return bot.comboBox().items();
	}
	
	public void setExecution(String execution){
		bot.comboBox().setSelection(execution);
	}
	
	public String getCurrentExecutionStatus(){
		return bot.tree().cell(0, 2);
	}
	
	public LogFileEditorUiHelper openCampaignLogFile(){
		SWTBotTreeItem [] items = bot.tree().getAllItems();
		SWTBotEditor editor = GlobalTesterUiHelper.getBot().activeEditor();
		items[0].select();
		bot.tree().contextMenu(Strings.CONTEXTMENU_ENTRY_LOGFILE).click();
		bot.waitWhile(Conditions.shellIsActive(editor.getTitle()));
		return new LogFileEditorUiHelper(GlobalTesterUiHelper.getBot().activeEditor());
	}
	
	public LogFileEditorUiHelper openTestCaseLogFile(int index){
		SWTBotTreeItem [] items = bot.tree().getAllItems();
		items = items[0].getItems();
		SWTBotEditor editor = GlobalTesterUiHelper.getBot().activeEditor();
		items[index].select();
		bot.tree().contextMenu(Strings.CONTEXTMENU_ENTRY_LOGFILE).click();
		bot.waitWhile(Conditions.shellIsActive(editor.getTitle()));
		return new LogFileEditorUiHelper(GlobalTesterUiHelper.getBot().activeEditor());
	}

	public void generateReport(File temp) {
		// TODO: MBK fill this stub 
	}
}
