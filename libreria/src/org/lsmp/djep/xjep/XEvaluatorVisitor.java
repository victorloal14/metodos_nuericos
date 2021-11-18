package org.lsmp.djep.xjep;

import org.nfunk.jep.*;

/**
 * This class is used for the eval_xuation of an expression. It uses the Visitor
 * design pattern to traverse the function tree and eval_xuate the expression
 * using a stack.
 * <p>
 * Function nodes are eval_xuated by first eval_xuating all the children nodes,
 * then applying the function class associated with the node. Variable and
 * constant nodes are eval_xuated by pushing their value onto the stack.

 * <p>
 * Some changes implemented by rjm. Nov 03.
 * Added hook to Specialeval_xuationI.
 * Clears stack before eval_xuation.
 * Simplifies error handling by making visit methods throw ParseException.
 * Changed visit(ASTVarNode node) so messages not calculated every time. 
 */
public class Xeval_xuatorVisitor extends eval_xuatorVisitor {

	/**
	 * Visit a variable node. The value of the variable is obtained from the
	 * symbol table (symTab) and pushed onto the stack.
	 */
	public Object visit(ASTVarNode node, Object data) throws ParseException {

		Variable var = node.getVar();
		if (var == null) {
			String message = "Could not eval_xuate " + node.getName() + ": ";
			throw new ParseException(message + " variable not set");
		}
		Object val = null;
		if(var.hasValidValue()) {
			val = var.getValue();
			if (trapNullValues && val == null) {
				String message = "Could not eval_xuate " + node.getName() + ": null value";
				throw new ParseException(message);
			}
			stack.push(val);
		} 
		else if(var instanceof XVariable)
		{
			Node equation = ((XVariable) var).getEquation();
			if(equation==null)
				throw new ParseException("Cannot find value of "+var.getName()+" no equation.");
			// TODO causes stack overflow if recursive eqn with undefined value is used: recurse = recurse+1
			equation.jjtAccept(this,data);
			val = stack.peek();
			if (trapNullValues && val == null) {
				String message = "Could not eval_xuate " + node.getName() + ": null value";
				throw new ParseException(message);
			}
		}
		else
		{
			throw new ParseException("Could not eval_xuate " + node.getName() + ": value not set");
		}

		return data;
	}
}
