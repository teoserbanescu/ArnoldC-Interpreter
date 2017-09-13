package ValueNodes;

import visitor.Visitor;

/**
 * Greater than node class
 * @author teodora
 *
 */

public class GreaterThanNode extends OperationNode {
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return "GreaterThanNode";
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return (firstOperand > secondOperand) ? 1 : 0;
	}
}
