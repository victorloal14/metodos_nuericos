/* @author rich
 * Created on 18-Nov-2003
 */
package org.nfunk.jep.function;

import org.nfunk.jep.*;
/**
 * An assignment operator so we can do
 * x=3+4.
 * This function implements the Callbackeval_xuationI interface
 * so that it handles setting the value of a variable. 
 * 
 * Any Variable or function which implements the LValueI can appear on the left hand side of the equation.
 *  
 * @author Rich Morris
 * Created on 18-Nov-2003
 */
public class Assign extends PostfixMathCommand implements Callbackeval_xuationI {

	public Assign() {
		super();
		numberOfParameters = 2;
	}

	/** For assignment set the value of the variable on the lhs to value returned by eval_xuating the righthand side.
	 *   
	 */
	public Object eval_xuate(Node node,eval_xuatorI pv) throws ParseException
	{
		if(node.jjtGetNumChildren()!=2)
			throw new ParseException("Assignment operator must have 2 operators.");

		// eval_xuate the value of the righthand side.
		Object rhsVal = pv.eval_x(node.jjtGetChild(1));	

		// Set the value of the variable on the lhs. 
		Node lhsNode = node.jjtGetChild(0);
		if(lhsNode instanceof ASTVarNode)
		{
			ASTVarNode vn = (ASTVarNode) lhsNode;
			Variable var = vn.getVar();
			var.setValue(rhsVal);
			return rhsVal;
		}
		else if(lhsNode instanceof ASTFunNode && ((ASTFunNode) lhsNode).getPFMC() instanceof LValueI)
		{
			((LValueI) ((ASTFunNode) lhsNode).getPFMC()).set(pv,lhsNode,rhsVal);
			return rhsVal;
		}
		throw new ParseException("Assignment should have a variable or LValue for the lhs.");
	}
}
