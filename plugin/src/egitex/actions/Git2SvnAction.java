package egitex.actions;

import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import egit_ex.util.MissingRequiredParameterException;
import egit_ex.util.ParameterSet;
import egit_ex.util.PromptCancelledException;
import egit_ex.util.RefParameter;

/**
 * Execute the Git operation that will find the SVN revision for a given Git Commit
 * 
 * @author reshapiro
 * 
 */
public class Git2SvnAction
      extends GitAction

      implements IWorkbenchWindowActionDelegate {
   
   private static final ParameterSet PARAMS = new ParameterSet("Show SVN revision for SHA", new RefParameter(2));
   
   private static final String[] ARGS = new String[] {
      "svn", "find-rev",  null
   };

   @Override
   String[] getArgs()
         throws PromptCancelledException, MissingRequiredParameterException {
      promptForParameters(PARAMS, ARGS);
      return ARGS;
   }

   @Override
   String getJobName() {
      return "Display SVN revision for a given SHA";
   }

   @Override
   boolean touch() {
      return false;
   }
}