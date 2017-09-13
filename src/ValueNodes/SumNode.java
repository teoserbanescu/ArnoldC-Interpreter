package ValueNodes;

import visitor.Visitor;
/**
 * Sum Node Class
 * Extends Operation Node
 * @author teodora
 *
 */

public class SumNode extends OperationNode {
	@Override
	public String toString() {
		return "SumNode";
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return firstOperand + secondOperand;
	}
}
