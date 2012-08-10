package org.globaltester.swtbot.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.uihelper.CardConfigWizardUiHelper;
import org.globaltester.swtbot.uihelper.ExportWizardUiHelper;
import org.globaltester.swtbot.uihelper.GlobalTesterUiHelper;
import org.globaltester.swtbot.uihelper.ImportWizardUiHelper;
import org.globaltester.swtbot.uihelper.LogFileEditorUiHelper;
import org.globaltester.swtbot.uihelper.NavigatorViewUiHelper;
import org.globaltester.swtbot.uihelper.TestCampaignEditorUiHelper;
import org.globaltester.swtbot.uihelper.TestCaseWizardUiHelper;
import org.globaltester.swtbot.uihelper.TestSpecificationWizardUiHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the workflows that are given as eclipse cheat cheet.
 * 
 * @author mboonk
 *
 */
public class TestWorkflow {
	private String projectName = "ProjectForTesting";
	private String sampleProject = "GlobalTester Sample TestSpecification";
	private File testFile;
	
	@Before
	public void prepare(){
		GlobalTesterUiHelper.init();
	}
	
	
	@Test
	public void createAndExportTestSpecification() throws IOException {
		TestSpecificationWizardUiHelper testSpecWizard = GlobalTesterUiHelper.openNewWizardByMenu().selectTestSpecification();
		testSpecWizard.setProjectName(projectName);
		testSpecWizard.finish();
		
		TestCaseWizardUiHelper testCaseWizard = GlobalTesterUiHelper.openNewWizardByMenu().selectTestCase();
		testCaseWizard.selectFolder(projectName);
		testCaseWizard.finish();
		
		ExportWizardUiHelper exportWizard = GlobalTesterUiHelper.openExportWizardByMenu();
		File tempFile = File.createTempFile("export", "pdf");
		exportWizard.selectTestSpecification(projectName);
		exportWizard.setExportDestination(tempFile);
		exportWizard.finish();
		testFile = File.createTempFile("export", "pdf");
		// check temporary folder for result
		assertTrue("No testspecification file exported", tempFile.length() > 0);
	}
	
	private void importTestSpecification(){
		ImportWizardUiHelper importWizard = GlobalTesterUiHelper.openImportWizardByMenu();
		importWizard.selectProject(sampleProject);
		importWizard.setProjectName(sampleProject);
		importWizard.finish();
	}
	
	private void createCardConfig(){
		CardConfigWizardUiHelper cardConfig = GlobalTesterUiHelper.openNewWizardByMenu().selectCardConfiguration();
		cardConfig.setProjectName("CardConfigProject");
		cardConfig.setDescription("TestDescription");
		cardConfig.setPin("1234");
		cardConfig.setMrz("P<D<<MUSTERMANN<<ERIKA<<<<<<<<<<<<<<<<<<<<<<", "C11T002JM4D<<9608122F1310317<<<<<<<<<<<<<<<6", "");
		cardConfig.finish();
	}
	
	@Test
	public void executeTestCases(){
		importTestSpecification();
		createCardConfig();
		NavigatorViewUiHelper navigator = GlobalTesterUiHelper.focusNavigatorView();
		String [] path1 = new String [] {sampleProject, "TestCases", "ePassport", "ePassport_Application.xml"};
		String [] path2 = new String [] {sampleProject, "TestCases", "nPA", "nPA_Application.xml"};
		navigator.expandAndSelect(path1);
		navigator.expandAndSelect(path2);
		GlobalTesterUiHelper.createAndStartTestCampaignByToolBar();
		SWTBotShell executionDialog = GlobalTesterUiHelper.getBot().shell(Strings.DIALOG_TITLE_TEST_EXECUTION);
		assertNotNull("Execution progress dialog did not open", executionDialog);
		GlobalTesterUiHelper.getBot().waitUntil(Conditions.shellCloses(executionDialog));
		TestCampaignEditorUiHelper editor = GlobalTesterUiHelper.focusTestCampaignEditor();
		LogFileEditorUiHelper logFile = editor.openTestCaseLogFile(0);
		assertTrue("log file editor should be active", logFile.isActive());
	}
	
	@After
	public void deleteFiles(){
		if (testFile != null){
			testFile.delete();
			testFile = null;
		}
	}
}
