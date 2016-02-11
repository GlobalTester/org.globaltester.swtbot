package org.globaltester.swtbot.matcher;

import org.eclipse.swt.widgets.Widget;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;


/**
 * Matches widgets which contain given data set with {@link org.eclipse.swt.widgets.Widget#setData(Object)}
 * 
 * @author mboonk
 *
 * @param <T>
 */
public class WidgetDataMatcher<T> extends BaseMatcher<T> {

	private String data;
	
	public WidgetDataMatcher(String data){
		this.data = data;
	}
	
	@Override
	public boolean matches(Object item) {
		if (item instanceof Widget){
			Widget widget = (Widget) item;
			if (data.equals(widget.getData())){
				return true;
			}
		}
		return false;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("Match widgets with data" + data);		
	}
}
