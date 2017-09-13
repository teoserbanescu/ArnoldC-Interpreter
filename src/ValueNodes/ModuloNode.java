package ValueNodes;

import visitor.Visitor;

/**
 * Modulo Node class
 * Extends Operation Node
 * @author teodora
 *
 */

public class ModuloNode extends OperationNode {
	@Override
	public String toString() {
		return "ModuloNode";
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return firstOperand % secondOperand;
	}
}
