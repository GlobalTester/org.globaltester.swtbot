package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.conditions.StyledTextContainsString;

/**
 * Provide a simple to use frontend for the smartcard shell view.
 * 
 * @author mboonk
 * 
 */
public class ScshViewUiHelper extends ViewUiHelper {

	protected ScshViewUiHelper(SWTBotView view) {
		super(view);
	}

	public String getConsoleText() {
		return bot.styledText().getText();
	}

	public void executeCommand(String command) {
		SWTBotText scshCommand = bot.textWithLabel(Strings.VIEW_SCSH_PROMPT);
		scshCommand.setFocus();
		scshCommand.setText(command);
		scshCommand.typeText("\n");
	}

	public boolean consoleContainsString(String string) {
		bot.waitUntil(new StyledTextContainsString(bot.styledText(), string));
		return true;
	}
}
