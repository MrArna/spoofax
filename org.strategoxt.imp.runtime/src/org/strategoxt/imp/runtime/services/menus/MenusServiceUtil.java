package org.strategoxt.imp.runtime.services.menus;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.internal.WorkbenchWindow;

/**
 * @author Oskar van Rest
 */
@SuppressWarnings("restriction")
public class MenusServiceUtil {

	public static void refreshToolbarMenuCommands() {
		ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		for (int i = 1; i <= MenusServiceConstants.NO_OF_TOOLBAR_MENUS; i++) {
			commandService.refreshElements(MenusServiceConstants.TOOLBAR_BASECOMMAND_ID_PREFIX + i, null);
		}
	}
	
	/**
	 * Resizes toolbar menus to reflect changed command labels.
	 */
	public static void refreshToolbarMenus() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		if (window instanceof WorkbenchWindow && ((WorkbenchWindow) window).getCoolBarVisible()) {
			ICoolBarManager coolBarManager = ((WorkbenchWindow) window).getCoolBarManager2();
			ToolBarContributionItem menu = (ToolBarContributionItem) coolBarManager.find(MenusServiceConstants.TOOLBAR_ID);
			
			if (menu != null) {
				menu.getToolBarManager().update(true);
				menu.setVisible(false);
				menu.setVisible(true);
			}
		}
	}
}
