package org.globaltester.swtbot.conditions;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
/**
 * Creates a positive result, if the styled text contains the given string.
 * 
 * @author mboonk
 *
 */
public class StyledTextContainsString extends DefaultCondition{

	SWTBotStyledText styledText;
	String string;
	
	public StyledTextContainsString(SWTBotStyledText text, String string){
		this.styledText = text;
		this.string = string;
	}
	
	@Override
	public boolean test() throws Exception {
		if (styledText.getText().contains(string)){
			return true;
		}
		return false;
	}

	@Override
	public String getFailureMessage() {
		return "Wanted string did not appear in styled text.";
	}

}
