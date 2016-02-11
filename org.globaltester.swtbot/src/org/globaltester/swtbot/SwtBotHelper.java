package org.globaltester.swtbot;

import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

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
		List<SWTBotView> views =  bot.views();
		// close all open views to get rid of all unwanted views
		for (SWTBotView view : views){
			view.close();
		}
		bot.resetWorkbench();
	}
	
	public static void selectInTree(SWTBotTree tree, String category, int index){
		for (SWTBotTreeItem item : tree.getAllItems()){
			if (item.getText().equals(category)){
				item.expand();
				item.getItems()[index].select();
				break;
			}
		}
	}

	public static void selectInTree(SWTBotTree tree, String category, String itemName){
		for (SWTBotTreeItem item : tree.getAllItems()){
			if (item.getText().equals(category)){
				item.expand();
				for (SWTBotTreeItem subItem : item.getItems()){
					if (subItem.getText().equals(itemName)){
						subItem.select();
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Slow down the speed of the SWTBot execution. Use only for development!
	 */
	public static void slowdown(){
		SWTBotPreferences.PLAYBACK_DELAY = 200;
	}

	/**
	 * Restore normal SWTBot execution speed. Use only for development!
	 */
	public static void resetSpeed(){
		SWTBotPreferences.PLAYBACK_DELAY = 0;
	}
	
	public static void sendEvent(final Widget widget, final int swtType){
		final Event event = new Event();
		event.type = swtType;
		event.widget = widget;
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				widget.notifyListeners(swtType, event);
			}
		});
	}

	public static void setUsKeyboardLayout() {
		SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
	}
}
