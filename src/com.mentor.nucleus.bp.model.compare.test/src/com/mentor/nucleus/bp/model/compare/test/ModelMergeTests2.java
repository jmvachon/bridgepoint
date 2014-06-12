package com.mentor.nucleus.bp.model.compare.test;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.CorePlugin;
import com.mentor.nucleus.bp.core.Interface_c;
import com.mentor.nucleus.bp.core.ModelClass_c;
import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.PackageableElement_c;
import com.mentor.nucleus.bp.core.common.BridgePointPreferencesStore;
import com.mentor.nucleus.bp.core.common.ClassQueryInterface_c;
import com.mentor.nucleus.bp.test.common.BaseTest;
import com.mentor.nucleus.bp.test.common.CompareTestUtilities;
import com.mentor.nucleus.bp.test.common.GitUtil;
import com.mentor.nucleus.bp.test.common.ZipUtil;
import com.mentor.nucleus.bp.ui.explorer.ModelContentProvider;
import com.mentor.nucleus.bp.ui.explorer.ModelLabelProvider;

public class ModelMergeTests2  extends BaseTest {
	private String test_repositories = Platform.getInstanceLocation().getURL()
			.getFile()
			+ "/" + "test_repositories";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mentor.nucleus.bp.test.common.BaseTest#initialSetup()
	 */
	@Override
	protected void initialSetup() throws Exception {
		CorePlugin
				.getDefault()
				.getPreferenceStore()
				.setValue(
						BridgePointPreferencesStore.ENABLE_ERROR_FOR_EMPTY_SYNCHRONOUS_MESSAGE,
						false);
		String test_repository_location = System
				.getenv("XTUML_TEST_MODEL_REPOSITORY");
		if (test_repository_location == null
				|| test_repository_location.equals("")) {
			// use the default location
			test_repository_location = BaseTest.DEFAULT_XTUML_TEST_MODEL_REPOSITORY;
		}
		test_repository_location = new Path(test_repository_location)
				.removeLastSegments(1).toString();
		ZipUtil.unzipFileContents(
				test_repository_location + "/"
						+ "test_repositories"
						+ "/" + "236-merge.zip",
				test_repositories);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.closeAllEditors(false);
	}

	public void testMergeInterfaceSortedElements() throws Exception {
		String projectName = "GPS Watch";
		// import git repository from models repo
		GitUtil.loadRepository(test_repositories
				+ "/" + projectName, "slave1");
		// import test project
		GitUtil.loadProject(projectName, projectName, "slave1");
		// merge the test branch
		GitUtil.mergeBranch("master1", projectName, "slave1");
		// start the merge tool
		GitUtil.startMergeTool(projectName);

		// Merge Pkg1 (6 incoming changes in master, 5 outgoing changes from slave)
		CompareTestUtilities.copyAllNonConflictingChangesFromRightToLeft();
		// validate
		assertTrue("Found conflicting changes remaining.", CompareTestUtilities
				.getConflictingChanges().size() == 0);
		assertTrue("Found incoming changes remaining.", CompareTestUtilities
				.getIncomingChanges().size() == 0);
		
		CompareTestUtilities.flushMergeEditor();

		m_sys = getSystemModel(projectName);		
		Interface_c iface = Interface_c.getOneC_IOnR8001(PackageableElement_c
				.getManyPE_PEsOnR8000(Package_c.getManyEP_PKGsOnR1401(m_sys)),
				new ClassQueryInterface_c() {

					@Override
					public boolean evaluate(Object candidate) {
						return ((Interface_c) candidate).getName().equals(
								"Pkg1");
					}
				});
		
		String[] orderedElements = new String[] { "m_op1", "m_op2", "sameName",
				"s_op1", "s_op2", "sameName", "m_sig1", "m_sig2", "sameName",
				"s_sig1", "s_sig2" };
		verifyOrder(orderedElements, iface);
		
		// There should be no error log entries (shutdown will verify this)
	}

	public void testMergeClassSortedElements() throws Exception {
		// Merge Library::Location::GPS  (4 incoming changes in master, 4 outgoing changes from slave)
		String projectName = "GPS Watch";
		// import git repository from models repo
		GitUtil.loadRepository(test_repositories
				+ "/" + projectName, "slave2");
		// import test project
		GitUtil.loadProject(projectName, projectName, "slave2");
		// merge the test branch
		GitUtil.mergeBranch("master2", projectName, "slave2");
		// start the merge tool
		GitUtil.startMergeTool(projectName);

		// Merge Pkg1 (6 incoming changes in master, 5 outgoing changes from slave)
		CompareTestUtilities.copyAllNonConflictingChangesFromRightToLeft();
		// validate
		assertTrue("Found conflicting changes remaining.", CompareTestUtilities
				.getConflictingChanges().size() == 0);
		assertTrue("Found incoming changes remaining.", CompareTestUtilities
				.getIncomingChanges().size() == 0);
		
		CompareTestUtilities.flushMergeEditor();

		m_sys = getSystemModel(projectName);		
		ModelClass_c clazz = ModelClass_c.getOneO_OBJOnR8001(PackageableElement_c
				.getManyPE_PEsOnR8000(Package_c.getManyEP_PKGsOnR1401(m_sys)),
				new ClassQueryInterface_c() {

					@Override
					public boolean evaluate(Object candidate) {
						return ((ModelClass_c) candidate).getName().equals(
								"GPS");
					}
				});
		
		String[] orderedElements = new String[] { "currentLocation", "timer",
				"m_a1", "m_a2", "s_a1", "s_a2", "m_o1", "m_o2", "s_o1", "s_o2",
				"Class State Machine" };
		verifyOrder(orderedElements, clazz);
		
		// TODO: Merge Library::Tracking::WorkoutTimer (1 incoming change in master, 1 outgoing change from slave)
		// TODO: Merge test1::iface1 (1 incoming change in master, 1 outgoing change from slave)
		// TODO: CompareWith... (just run compare with and open the editor for one of he changes, 
		// There should be no error log entries (shutdown will verify this)
	}
	
	private void verifyOrder(String[] orderedElements, Object parent) {
		ModelContentProvider provider = new ModelContentProvider();
		ModelLabelProvider labelProvider = new ModelLabelProvider();
		Object[] children = provider.getChildren(parent);
		for (int i = 0; i < children.length; i++) {
			assertTrue(
					"Found unexpected element in the children list after merge.",
					labelProvider.getText(children[i]).equals(
							orderedElements[i]));
		}
	}


}
