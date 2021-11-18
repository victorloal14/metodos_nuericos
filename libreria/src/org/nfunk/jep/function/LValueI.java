/*
Created 16-May-2006 - Richard Morris
*/
package org.nfunk.jep.function;

import org.nfunk.jep.eval_xuatorI;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 * @author Richard Morris
 * An interface for functions which can be used on the left hand side of an assignment.
 * For instance
 * a[3] = 5
 * sets the third element of a to the value 5.
 */
public interface LValueI {
	/**
	 * Performs appropriate action to set an LValue.
	 * @param pv a pointer to the eval_xuator. The pv.eval_x() method can be used to eval_xuate the children of the node.
	 * @param node The top node for the LValue
	 * @param value the value obtained by eval_xuating the right hand side.
	 * @throws ParseException
	 */
	public void set(eval_xuatorI pv,Node node,Object value) throws ParseException;
}
