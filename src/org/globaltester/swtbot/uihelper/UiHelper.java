package org.globaltester.swtbot.uihelper;

import java.io.File;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;

/**
 * A UiHelper is a class, that abstracts from direct use of SWTBot methods
 * by providing methods that resemble the view of a user on functional UI
 * units.
 * 
 * @author mboonk
 *
 */
public abstract class UiHelper{

	protected SWTBot bot = null;
	
	protected UiHelper(SWTBot bot){
		this.bot = bot;
	}
	
	/**
	 * Capture a screenshot of the area used by the wrapped part of the user interface.
	 * 
	 * @param fileName
	 */
	public void captureScreenshot(String fileName){
		SWTUtils.captureScreenshot("screenshots"+File.separator+fileName, bot.activeShell().widget);
	}
}
