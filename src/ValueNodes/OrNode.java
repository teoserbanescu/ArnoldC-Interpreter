package ValueNodes;

import visitor.Visitor;
/**
 * Or Node class
 * Extends Operation Node
 * @author teodora
 *
 */

public class OrNode extends OperationNode {
	
	@Override
	public String toString() {
		return "OrNode";
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return (firstOperand > 0 || secondOperand > 0) ? 1 : 0;
	}
}
