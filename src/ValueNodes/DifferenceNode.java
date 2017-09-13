package ValueNodes;
import visitor.Visitor;

/**
 * Difference Node class
 * Extends Operation Node
 * @author teodora
 *
 */

public class DifferenceNode extends OperationNode {
	@Override
	public String toString() {
		return "DifferenceNode";
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return firstOperand - secondOperand;
	}
}
