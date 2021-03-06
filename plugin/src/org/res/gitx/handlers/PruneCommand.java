package org.res.gitx.handlers;

import org.res.gitx.parameter.MissingRequiredParameterException;
import org.res.gitx.parameter.Parameter;
import org.res.gitx.parameter.ParameterSet;
import org.res.gitx.parameter.PromptCancelledException;

/**
 * Execute the Git operation that delete obsolete remote references
 * 
 * @author reshapiro
 * 
 */
public class PruneCommand
      extends GitCommandHandler {

   private static final Parameter REF = new Parameter("Remote", true, "origin");
   private static final ParameterSet PARAMS = new ParameterSet("Prune remote refs", REF);

   @Override
   void getArgs()
         throws PromptCancelledException, MissingRequiredParameterException {
      promptForParameters(PARAMS);
      append("remote", "prune").append(PARAMS, REF);
   }

   @Override
   String getJobName() {
      return "Delete obsolete remote refs";
   }

   @Override
   boolean touch() {
      return false;
   }
}