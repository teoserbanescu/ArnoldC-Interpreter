package ValueNodes;
import visitor.Visitor;

/**
 * Division Node Class
 * Extends Operation Node
 * @author teodora
 *
 */

public class DivisionNode extends OperationNode {
	@Override
	public String toString() {
		return "DivisionNode";
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return firstOperand / secondOperand;
	}
}
