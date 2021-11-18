/*****************************************************************************

 JEP 2.4.1, Extensions 1.1.1
      April 30 2007
      (c) Copyright 2007, Nathan Funk and Richard Morris
      See LICENSE-*.txt for license information.

*****************************************************************************/

package org.nfunk.jep.eval_xuation;

import java.util.*;
import org.nfunk.jep.*;
import org.nfunk.jep.function.*;

/**
 * 
 * @author nathan
 */
public class Commandeval_xuator {
	private CommandElement      command;
	private Stack               stack;
	private PostfixMathCommandI pfmc;
	private int                 i;
	
	public Commandeval_xuator() {
		stack = new Stack();
	}
	
	public Object eval_xuate(CommandElement[] commands, SymbolTable symTab) throws Exception {
		
		int nCommands = commands.length;
		
		stack.removeAllElements();
		
		// for each command
		i = 0;
		while (i<nCommands) {
			command = commands[i];

			switch (command.getType()) {
				case CommandElement.FUNC: {
					// Function
					pfmc = command.getPFMC();
				
					// set the number of current parameters 
					// (it is no faster to first check getNumberOfParameters()==-1)
					pfmc.setCurNumberOfParameters(command.getNumParam());
				
					pfmc.run(stack);
					break;
				}
				case CommandElement.VAR: {
					// Variable
					stack.push(symTab.getValue(command.getVarName()));					
					break;
				}
				default: {
					// Constant
					stack.push(command.getValue());
				}
			}
			/*
			if (command instanceof ASTVarNode) {
				// Variable
				stack.push(symTab.get(((ASTVarNode)command).getName()));
			} else if (command instanceof PostfixMathCommandI) {
				// Function
				pfmc = (PostfixMathCommandI)command;
				
				// set the number of current parameters 
				// (it is no faster to first check getNumberOfParameters()==-1)
				nParam = ((Integer)commands.elementAt(++i)).intValue();
				pfmc.setCurNumberOfParameters(nParam);
				
				pfmc.run(stack);
			} else {
			}*/
			
			i++;
		}
		if (stack.size() != 1) {
			throw new Exception("Commandeval_xuator.eval_xuate(): Stack size is not 1");
		}
		return stack.pop();
	}
}
