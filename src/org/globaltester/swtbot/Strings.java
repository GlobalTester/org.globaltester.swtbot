package org.globaltester.swtbot;


/**
 * Provides UI Strings for use in SWTBot testcases.
 * 
 * @author mboonk
 *
 */
public interface Strings {
	public static final String WORKBENCH_TITLE = "GlobalTester";
	
	// menu related
	public static final String MENU_FILE = "File";
	public static final String MENU_ENTRY_IMPORT = "Import...";
	public static final String MENU_ENTRY_EXPORT = "Export...";
	public static final String MENU_ENTRY_NEW = "New";
	
	// wizard and dialog related
	public static final String WIZARD_TITLE_IMPORT = "Import";
	public static final String WIZARD_TITLE_EXPORT = "Export";
	public static final String WIZARD_TITLE_NEW = "New";
	public static final String WIZARD_TITLE_TESTSPECIFICATION_EXPORT = "GlobalTester TestSpecification Export Wizard";
	public static final String WIZARD_TITLE_TESTSPECIFICATION_IMPORT = "GlobalTester TestSpecification Import Wizard";
	public static final String WIZARD_TITLE_CARDCONFIG = "GlobalTester CardConfiguration Wizard";
	public static final String DIALOG_TITLE_EXPORT = "Export";
	public static final String DIALOG_TITLE_IMPORT = "Import";
	public static final String DIALOG_TITLE_IMPORT_PROGRESS = "Progress Information";
	public static final String DIALOG_TITLE_CARDCONFIG = "Select CardConfig";
	public static final String DIALOG_TITLE_TEST_EXECUTION = "Test execution";
	
	public static final String WIZARD_CATEGORY_GLOBALTESTER = "GlobalTester";
	
	public static final String WIZARD_ITEM_EXPORT = "Export TestSpecification to OpenDocument Format";
	public static final String WIZARD_ITEM_IMPORT = "Import TestSpecification from Plugin";
	public static final String WIZARD_ITEM_TESTCASE = "TestCase";
	public static final String WIZARD_ITEM_TESTSPECIFICATION = "TestSpecification";
	public static final String WIZARD_ITEM_CARDCONFIG = "CardConfiguration";
	
	public static final String WIZARD_BUTTON_NEXT = "Next >";
	public static final String WIZARD_BUTTON_BACK = "< Back";
	public static final String WIZARD_BUTTON_FINISH = "Finish";
	public static final String WIZARD_BUTTON_CANCEL = "Cancel";
	
	// labels
	public static final String LABEL_STYLESHEET = "Stylesheet:";
	
	// views
	public static final String VIEW_NAVIGATOR = "GlobalTester Navigator";
	
	// toolbar related
	public static final String TOOLBAR_TOOLTIP_CREATE_AND_EXECUTE = "Create a new TestCampaign from selection and execute it";

	// tabs
	public static final String TAB_ITEM_CARDCONFIG_PASSWORDS = "Passwords";
	public static final String TAB_ITEM_CARDCONFIG_GENERAL = "General";
	public static final String TAB_ITEM_CARDCONFIG_ICAO9303 = "ICAO9303";

	public static final String BUTTONS_CARDCONFIG_OK = "OK";
	public static final String BUTTONS_CARDCONFIG_NEW = "New";

	public static final String FILENAME_TESTCAMPAIGN = "testCampaign.xml";

	public static final String CONTEXTMENU_ENTRY_RUNTEST = "Run Test";
	public static final String CONTEXTMENU_ENTRY_OPEN = "Open";
	public static final String CONTEXTMENU_ENTRY_LOGFILE = "Show log file";

	public static final String BUTTONS_GENERATE_REPORT = "Generate Report";

	public static final String BUTTONS_DIALOG_OK = "OK";
	public static final String BUTTONS_DIALOG_CANCEL = "Abbrechen";

	public static final String BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_BEGIN = "|<<";
	public static final String BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_END = ">>|";
	public static final String BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_NEXT = ">";
	public static final String BUTTON_EDITOR_TESTCAMPAIGN_HISTORY_BACK = "<";

	public static final String EDITOR_ID_LOGFILE = "org.globaltester.logging.ui.logFileEditor";
	public static final String EDITOR_ID_TESTCAMPAIGN = "org.globaltester.testrunner.ui.testcampaigneditor";

	
	
}
