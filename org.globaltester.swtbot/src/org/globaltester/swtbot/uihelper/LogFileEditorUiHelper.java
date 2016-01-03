package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;

/**
 * @author mboonk
 *
 */
public class LogFileEditorUiHelper extends EditorUiHelper {

	LogFileEditorUiHelper(SWTBotEditor editor) {
		super(editor);
	}

	public int getNumberOfLines(){
		return bot.styledText().getLineCount();
	}
}
