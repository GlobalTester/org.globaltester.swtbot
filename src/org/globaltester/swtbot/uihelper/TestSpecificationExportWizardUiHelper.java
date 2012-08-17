package org.globaltester.swtbot.uihelper;

import java.io.File;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.ControlFinder;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotList;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.SwtBotHelper;
import org.globaltester.swtbot.matcher.InvisibleControlMatcher;
import org.globaltester.swtbot.matcher.WidgetDataMatcher;

public class TestSpecificationExportWizardUiHelper extends WizardUiHelper {

	protected TestSpecificationExportWizardUiHelper(SWTBot bot) {
		super(bot);
	}
	public void selectTestSpecification(String name) {
		goToPage(0);
		SWTBotList specs = bot.list(0);
		specs.select(name);
	}

	public void selectExportLayout(String name){
		goToPage(0);
		SWTBotList exporters = bot.list(1);
		exporters.select(name);
	}
	
	public void setExportDestination(File destination){
		goToPage(0);
		SWTBotText text = bot.text(1);
		text.setText(destination.toString());

		SwtBotHelper.sendEvent(text.widget, SWT.Modify);
	}
	
	public void setAdditionalData(String key, String value){
		goToPage(1);
		Text text = bot.widget(new WidgetDataMatcher<Text>(key));
		SWTBotText swtText = new SWTBotText(text);
		swtText.typeText(value);
	}
	
	public int getNumberOfTestSpecifications(){
		goToPage(0);
		SWTBotList projectList = bot.list(0);
		return projectList.itemCount();
	}
	
	public int getNumberOfExporters(){
		goToPage(0);
		SWTBotList exporters = bot.list(1);
		return exporters.itemCount();
	}
	
	public boolean hasExporter(String name){
		goToPage(0);
		SWTBotList exporters = bot.list(1);
		for (String s : exporters.getItems()){
			if (s.equals(name)){return true;}
		}
		return false;
	}
	
	public boolean visibilityOfCustomOptions(){
		goToPage(0);
		ControlFinder finder = new ControlFinder();
		finder.shouldFindInVisibleControls = true;
		final List<Label> labels = finder
				.findControls(new InvisibleControlMatcher<Label>(Label.class));

		// check if invisible label exists
		boolean result = UIThreadRunnable.syncExec(Display.getDefault(), new Result<Boolean>() {
			public Boolean run() {
				for (Label label : labels) {
					if (label instanceof Label && ((Label) label).getText().equals(Strings.LABEL_STYLESHEET)){
						return false;
					}
				}
				return true;
			}
		});

		return result;
	}
	
	@Override
	public void finishingActions(){
		bot.waitUntil(Conditions.shellIsActive(Strings.DIALOG_TITLE_EXPORT));
		bot.shell(Strings.DIALOG_TITLE_EXPORT).bot().button().click();
	}
}
