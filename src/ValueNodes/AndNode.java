package ValueNodes;

import visitor.Visitor;

/**
 * And Node Class
 * Extends Operation Node
 * @author teodora
 *
 */

public class AndNode extends OperationNode {
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return (firstOperand > 0 && secondOperand > 0) ? 1 : 0;
	}
	
	@Override
	public String toString() {
		return "AndNode";
	}
}
