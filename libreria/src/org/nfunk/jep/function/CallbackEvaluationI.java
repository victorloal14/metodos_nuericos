/* @author rich
 * Created on 18-Nov-2003
 */
package org.nfunk.jep.function;
import org.nfunk.jep.*;
/**
 * Functions which require greater control over their eval_xuation should implement this interface.
 *
 * @author Rich Morris
 * Created on 18-Nov-2003
 */
public interface Callbackeval_xuationI {

	/**
	 * Performs some special eval_xuation on the node.
	 * This method has the responsibility for eval_xuating the children of the node
	 * and it should generally call
	 * <pre>
	 * pv.eval_x(node.jjtGetChild(i))	
	 * </pre>
	 * for each child.
	 * 
	 * The SymbolTable is not passed as an argument. This is because
	 * it is better practice to get and set variable values by using
	 * node.getVar().setValue() rather that through the SymbolTable with
	 * requires a hashtable lookup.
	 *
	 * @param node	The current node
	 * @param pv	The visitor, can be used eval_xuate the children
	 * @return the value after eval_xuation
	 * @throws ParseException
	 */
	public Object eval_xuate(Node node,eval_xuatorI pv) throws ParseException;
}
