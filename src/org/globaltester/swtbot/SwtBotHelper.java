package org.globaltester.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

/**
 * Convenience class that provides several wrapper methods to simplify usage of
 * SwtBot. Especially overall setup of GlobalTester workbench for most testcases
 * is handled and some repeated actions are extracted here.
 * 
 * @author amay
 * 
 */
public class SwtBotHelper {

	public static void resetWorkbenchState(SWTWorkbenchBot bot) {

		// close welcome view
		SWTBotView welcomeView = bot.viewByTitle("Welcome");
		if (welcomeView != null) {
			welcomeView.close();
		}

	}
}
