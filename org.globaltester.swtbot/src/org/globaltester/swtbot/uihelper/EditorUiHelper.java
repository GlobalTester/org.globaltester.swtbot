package org.globaltester.swtbot.uihelper;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;

/**
 * Provide generic methods for editors.
 * 
 * @author mboonk
 *
 */
public class EditorUiHelper extends WorkbenchPartUiHelper {
	SWTBotEditor editor;
	
	EditorUiHelper(SWTBotEditor editor) {
		super(editor);
		this.editor = editor;
	}
	
	public void close (){
		editor.close();
	}
	
	public void save (){
		editor.save();
	}

	public boolean isActive(){
		return editor.isActive();
	}
	
}
