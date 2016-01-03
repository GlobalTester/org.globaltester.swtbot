package org.globaltester.swtbot.conditions;

import org.eclipse.swtbot.swt.finder.utils.StringUtils;
import org.eclipse.swtbot.swt.finder.utils.internal.Assert;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 * Creates a positive result, if one of the open shells has one of the given texts.
 * 
 * @author mboonk
 *
 */
public class AnyShellIsActive extends DefaultCondition {
	private String[] texts;
	
	public AnyShellIsActive(String ...texts) {
		this.texts = texts;
		for (String text : texts){
			Assert.isNotNull(text, "The shell text was null"); //$NON-NLS-1$
			Assert.isLegal(!StringUtils.isEmpty(text), "The shell text was empty"); //$NON-NLS-1$
		}
	}
	
	@Override
	public boolean test() throws Exception {
		SWTBotShell shell = bot.activeShell();
		
		for (String text : texts) {
			if (shell.getText().equals(text)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String getFailureMessage() {
		String result = "None of the shells '";
		for (String text : texts){
			result += text + " ";
		}
		return  result + "' did activate"; //$NON-NLS-1$ //$NON-NLS-2$
	}

}
