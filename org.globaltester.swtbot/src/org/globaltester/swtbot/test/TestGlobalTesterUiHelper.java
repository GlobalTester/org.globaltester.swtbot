package org.globaltester.swtbot.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.globaltester.junit.JUnitHelper;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.uihelper.AboutDialogUiHelper;
import org.globaltester.swtbot.uihelper.GlobalTesterUiHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the UiHelpers.
 * 
 * @author mboonk
 *
 */
public class TestGlobalTesterUiHelper {
	@Before
	public void prepare() throws CoreException{
		GlobalTesterUiHelper.init();
	}
	
	@Test
	public void testCreateAndStartTestCampaignByToolbar() throws IOException, CoreException{
		JUnitHelper.createDefaultTestSpec();
		JUnitHelper.createDefaultCardConfig();
		GlobalTesterUiHelper.focusNavigatorView().expandAndSelect(JUnitHelper.testSpec, "TestCases", "Unit1", "testcase1.xml");
		GlobalTesterUiHelper.createAndStartTestCampaignByToolBar();
		SWTBot bot = GlobalTesterUiHelper.getBot();
		String shellText = bot.activeShell().getText();
		assertTrue("Test execution progress monitor opens", shellText.equals(Strings.DIALOG_TITLE_TEST_EXECUTION));
	}
	
	@Test
	public void testCreateAndStartTestCampaignByToolbarOtherCardConfig() throws IOException, CoreException{
		JUnitHelper.createDefaultTestSpec();
		JUnitHelper.createDefaultCardConfig();
		GlobalTesterUiHelper.focusNavigatorView().expandAndSelect(JUnitHelper.testSpec, "TestCases", "Unit1", "testcase1.xml");
		GlobalTesterUiHelper.createAndStartTestCampaignByToolBarOtherCardConfig();
		SWTBot bot = GlobalTesterUiHelper.getBot();
		String shellText = bot.activeShell().getText();
		assertTrue("Card config dialog opens", shellText.equals(Strings.DIALOG_TITLE_CARDCONFIG));
	}
	
	@Test
	public void testOpenExportWizardByMenu(){
		GlobalTesterUiHelper.openExportWizardByMenu().openTestSpecificationExportWizard();
		
		SWTBot bot = GlobalTesterUiHelper.getBot();
		String shellText = bot.activeShell().getText();
		assertTrue("Export wizard opens", shellText.equals(Strings.WIZARD_TITLE_TESTSPECIFICATION_EXPORT));
	}
	
	@Test
	public void testOpenImportWizardByMenu(){
		GlobalTesterUiHelper.openImportWizardByMenu().openTestSpecificationImportWizard();
		SWTBot bot = GlobalTesterUiHelper.getBot();
		String shellText = bot.activeShell().getText();
		assertTrue("Import wizard opens", shellText.equals(Strings.WIZARD_TITLE_TESTSPECIFICATION_IMPORT));
	}
	
	@Test
	public void testOpenNewWizardByMenu(){
		GlobalTesterUiHelper.openNewWizardByMenu();

		SWTBot bot = GlobalTesterUiHelper.getBot();
		String shellText = bot.activeShell().getText();
		assertTrue("New wizard opens", shellText.equals(Strings.WIZARD_TITLE_NEW));
	}
	
	@Test
	public void testOpenAboutDialog(){
		AboutDialogUiHelper dialog = GlobalTesterUiHelper.openAboutDialog();
		dialog.captureScreenshot(Strings.FILE_SCREENSHOTS_SUBFOLDER + File.separator + "AboutDialog.png");
		String shellText = dialog.getBot().activeShell().getText();
		assertTrue("About dialog opens", shellText.equals(Strings.DIALOG_TITLE_ABOUT));
	}
	
	@Test
	public void testApplicationWindow() {
		GlobalTesterUiHelper.captureScreenshot(Strings.FILE_SCREENSHOTS_SUBFOLDER + File.separator + "MainWindow.png");
		assertNotNull(GlobalTesterUiHelper.getBot().shell(Strings.WORKBENCH_TITLE));
	}
}
