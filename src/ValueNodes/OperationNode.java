package ValueNodes;

/**
 * Operation Node Class
 * Abstract Class
 * Extends ValueNode because all operation nodes have values
 * @author teodora
 *
 */

public abstract class OperationNode extends ValueNode {
	/**
	 * does the required operations for the two childs
	 */
	public void doOperation() {
		ValueNode firstOperand = (ValueNode) this.getSubordinateAt(0);
		ValueNode secondOperand = (ValueNode) this.getSubordinateAt(1);
		this.setValue(this.result(firstOperand.getValue(), secondOperand.getValue()));
	}
	/**
	 * Abstract method returning the result of the operation
	 * Implemented by all operations
	 * @param a
	 * @param b
	 * @return
	 */
	public abstract Integer result(Integer a, Integer b);
}
