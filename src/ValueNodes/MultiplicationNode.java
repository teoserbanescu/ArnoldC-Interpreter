package ValueNodes;
import visitor.Visitor;

/**
 * Multiplication Node class
 * Extends Operation Node
 * @author teodora
 *
 */

public class MultiplicationNode extends OperationNode {
	@Override
	public String toString() {
		return "MultiplicationNode";
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return firstOperand * secondOperand;
	}
}
