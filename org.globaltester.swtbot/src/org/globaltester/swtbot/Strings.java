package org.globaltester.swtbot;


/**
 * Provides UI Strings for use in SWTBot testcases.
 * 
 * @author mboonk
 *
 */
public interface Strings {
	public static final String WORKBENCH_TITLE = "GlobalTester Platform";
	public static final String FILE_SCREENSHOTS_SUBFOLDER = "screenshots";
	// menu related
	public static final String MENU_FILE = "File";
	public static final String MENU_ENTRY_IMPORT = "Import...";
	public static final String MENU_ENTRY_EXPORT = "Export...";
	public static final String MENU_ENTRY_NEW = "New";
	public static final String MENU_ENTRY_ABOUT = "About GlobalTester RCP";
	public static final String MENU_HELP = "Help";
	
	// wizard and dialog related
	public static final String WIZARD_TITLE_IMPORT = "Import";
	public static final String WIZARD_TITLE_EXPORT = "Export";
	public static final String WIZARD_TITLE_NEW = "New";
	public static final String WIZARD_TITLE_TESTSPECIFICATION_EXPORT = "GlobalTester TestSpecification Export Wizard";
	public static final String WIZARD_TITLE_TESTSPECIFICATION_IMPORT = "GlobalTester TestSpecification Import Wizard";
	public static final String WIZARD_TITLE_SAMPLECONFIG = "GlobalTester SampleConfiguration Wizard";
	public static final String DIALOG_TITLE_EXPORT = "Export";
	public static final String DIALOG_TITLE_IMPORT = "Import";
	public static final String DIALOG_TITLE_IMPORT_PROGRESS = "Progress Information";
	public static final String DIALOG_TITLE_SAMPLECONFIG = "Select SampleConfig";
	public static final String DIALOG_TITLE_TEST_EXECUTION = "Test execution";
	public static final String DIALOG_TITLE_ABOUT = "About GlobalTester RCP";
	public static final String DIALOG_TITLE_DIRECTORY = "Ordner suchen";
	public static final String DIALOG_TITLE_FILE = "FileDialog";
	public static final String DIALOG_TITLE_REPORT_SUCCESS = "PDF report";
	
	public static final String WIZARD_CATEGORY_GLOBALTESTER = "GlobalTester";
	
	public static final String WIZARD_ITEM_EXPORT = "Export TestSpecification to OpenDocument Format";
	public static final String WIZARD_ITEM_IMPORT = "Import TestSpecification from Plugin";
	public static final String WIZARD_ITEM_TESTCASE = "TestCase";
	public static final String WIZARD_ITEM_TESTSPECIFICATION = "TestSpecification";
	public static final String WIZARD_ITEM_SAMPLECONFIG = "SampleConfiguration";
	
	public static final String WIZARD_BUTTON_NEXT = "Next >";
	public static final String WIZARD_BUTTON_BACK = "< Back";
	public static final String WIZARD_BUTTON_FINISH = "Finish";
	public static final String WIZARD_BUTTON_CANCEL = "Cancel";
	
	// labels
	public static final String LABEL_STYLESHEET = "Stylesheet:";
	
	// views
	public static final String VIEW_NAVIGATOR = "GlobalTester Navigator";
	public static final String VIEW_SCSH = "SmartCardShell View";
	public static final String VIEW_SCSH_PROMPT = "scsh>";
	
	// toolbar related
	public static final String TOOLBAR_TOOLTIP_CREATE_AND_EXECUTE = "Create a new TestCampaign from selection and execute it";

	// tabs
	public static final String TAB_ITEM_SAMPLECONFIG_PASSWORDS = "Passwords";
	public static final String TAB_ITEM_SAMPLECONFIG_GENERAL = "General";
	public static final String TAB_ITEM_SAMPLECONFIG_ICAO9303 = "ICAO9303";

	public static final String BUTTONS_SAMPLECONFIG_OK = "OK";
	public static final String BUTTONS_SAMPLECONFIG_NEW = "New";

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

	public static final String EDITOR_ID_LOGFILE = "org.globaltester.logging.logfileeditor.ui.logFileEditor";
	public static final String EDITOR_ID_TESTCAMPAIGN = "org.globaltester.testrunner.ui.testcampaigneditor";
	
	public static final String SAMPLE_TESTSPEC = "GlobalTester Sample TestSpecification";
		
}
