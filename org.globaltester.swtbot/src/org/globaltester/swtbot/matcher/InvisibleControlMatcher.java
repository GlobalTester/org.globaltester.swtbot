package org.globaltester.swtbot.matcher;

import org.eclipse.swt.widgets.Control;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class InvisibleControlMatcher<T extends Control> extends BaseMatcher<T> {

	Class<T> clazz;
	
	public InvisibleControlMatcher(Class<T> type){
		clazz = type;
	}
	
	@Override
	public boolean matches(Object item) {
		if (item.getClass() == clazz){
			if (!((Control) item).isVisible()){
				return true;
			}
		}
		return false;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("Matches invisible controls.");
		
	}

}
