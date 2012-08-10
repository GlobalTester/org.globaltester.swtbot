package org.globaltester.swtbot.uihelper;

import java.io.File;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotList;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.matcher.WidgetDataMatcher;

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

	public void selectTestSpecification(String name) {
		SWTBotList specs = bot.list(0);
		specs.select(name);
	}

	public void selectExportLayout(String name){
		SWTBotList exporters = bot.list(1);
		exporters.select(name);
	}
	
	public void setExportDestination(File destination){
		SWTBotText text = bot.text(1);
		text.setText(destination.toString());
		// swtbot cannot type ":" 
		text.pressShortcut(Keystrokes.SPACE);
		text.pressShortcut(Keystrokes.BS);
	}
	
	public void setAdditionalData(String key, String value){
		Text text = bot.widget(new WidgetDataMatcher<Text>(key));
		SWTBotText swtText = new SWTBotText(text);
		swtText.typeText(value);
	}
	
	public int getNumberOfTestSpecifications(){
		SWTBotList projectList = bot.list(0);
		return projectList.itemCount();
	}
	
	public int getNumberOfExporters(){
		SWTBotList exporters = bot.list(1);
		return exporters.itemCount();
	}
	
	public boolean hasExporter(String name){
		SWTBotList exporters = bot.list(1);
		for (String s : exporters.getItems()){
			if (s.equals(name)){return true;}
		}
		return false;
	}
	
	public boolean visibilityOfCustomOptions(){
		SWTBotLabel stylesheetLabel = bot.label(Strings.LABEL_STYLESHEET);
		return stylesheetLabel.isVisible();
	}
	
	@Override
	public void finishingActions(){
		bot.waitUntil(Conditions.shellIsActive(Strings.DIALOG_TITLE_EXPORT));
		bot.shell(Strings.DIALOG_TITLE_EXPORT).bot().button().click();
	}
}
