package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.swt.finder.SWTBot;

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
}
