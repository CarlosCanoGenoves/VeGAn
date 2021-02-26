package vegan.actions;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;
import VISUAL.*;

public class SampleAction extends ActionDelegate implements IActionDelegate {
	/**
	 * Selected model files.
	 */
	protected List<IFile> files;

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.ui.actions.ActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void selectionChanged(IAction action, ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      files = ((IStructuredSelection) selection).toList();
    }
  }
	
	@Override
	public void run(IAction action) {
		Visual.showVisual(files.get(0).getFullPath().toString());
	}
}
