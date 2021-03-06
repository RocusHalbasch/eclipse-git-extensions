package org.res.gitx.handlers;

import org.res.gitx.parameter.MissingRequiredParameterException;
import org.res.gitx.parameter.ParameterSet;
import org.res.gitx.parameter.PromptCancelledException;
import org.res.gitx.parameter.RefPair;
import org.res.gitx.parameter.RefParameter;
import org.res.gitx.parameter.RefParameterWithDefault;

/**
 * List files which differ between two branches.
 * 
 * @author reshapiro
 * 
 */
public class ListChangedFiles
      extends GitCommandHandler {

   private static final RefParameter REF1 = new RefParameterWithDefault("HEAD", "Ref 1");
   private static final RefParameter REF2 = new RefParameter("Ref 2");
   private static final RefPair GROUP = new RefPair(REF1, REF2);

   private static final ParameterSet PARAMETERS = new ParameterSet("List files with differences", GROUP);

   @Override
   void getArgs()
         throws PromptCancelledException, MissingRequiredParameterException {
      promptForParameters(PARAMETERS);
      append("diff", "--stat").append(PARAMETERS, REF1, REF2);
   }

   @Override
   String getJobName() {
      return "List commits in one branch but not another";
   }

   @Override
   boolean touch() {
      return false;
   }
}