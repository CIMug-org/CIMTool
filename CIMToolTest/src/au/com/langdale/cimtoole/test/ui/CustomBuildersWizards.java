package au.com.langdale.cimtoole.test.ui;

import org.eclipse.core.runtime.CoreException;

import au.com.langdale.cimtoole.CIMToolPlugin;
import au.com.langdale.cimtoole.project.Info;
import au.com.langdale.cimtoole.test.WorkbenchTest;
import au.com.langdale.cimtoole.wizards.ImportTransformBuilder;
import au.com.langdale.kena.OntModel;
import au.com.langdale.ui.builder.Assembly;

public class CustomBuildersWizards extends WorkbenchTest {
	public final void testImportSchema() throws CoreException {
		ImportTransformBuilder wizard = new ImportTransformBuilder();
		TestWizardDialog dialog = runWizard(wizard);
		pause();
		Assembly content = dialog.getContent();
		content.getText("source").setText(getSamplesFolder() + SAMPLE_SCHEMA);
		assertEquals("suggested file", SAMPLE_SCHEMA, content.getText("filename").getText());
		pause();
		content.getCheckboxTableViewer("projects").setChecked(project, true);
		content.fireWidgetEvent();
		pause();
		assertTrue(wizard.canFinish());
		dialog.finishPressed();
		OntModel result = CIMToolPlugin.getCache().getMergedOntologyWait(Info.getSchemaFolder(project));
		long size = result.size();
		assertTrue("expected schema size", size > 10000);
	}
}
