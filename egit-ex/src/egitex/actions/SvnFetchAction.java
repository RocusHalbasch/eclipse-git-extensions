package egitex.actions;

import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Execute the Git operation that will 'fetch' any new commits from SVN on any
 * branch to the corresponding Git branch.
 * 
 * @author reshapiro
 * 
 */
public class SvnFetchAction
      extends GitAction

      implements IWorkbenchWindowActionDelegate {
   private static final String OPERATION_NAME = "fetch from svn";
   private static final String[] ARGS = new String[] {
      "svn",
      "fetch"
   };

   @Override
   String getOperationName() {
      return OPERATION_NAME;
   }

   @Override
   String[] getArgs() {
      return ARGS;
   }
}