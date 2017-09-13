package ValueNodes;

import visitor.Visitor;

public class EqualToNode extends OperationNode {
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return "EqualToNode";
	}
	
	public Integer result(Integer firstOperand, Integer secondOperand) {
		return (firstOperand == secondOperand) ? 1 : 0;
	}
}