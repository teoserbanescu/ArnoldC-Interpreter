package NumbLeafNodes;

import visitor.Visitor;

/**
 * Lval Node
 * Extends VariableNode
 * @author teodora
 *
 */

public class LvalNode extends VariableNode {

	public LvalNode(String variable) {
		super(variable);
	}
	
	@Override
	public String toString() {
		return "LvalNode <" + variable.toString() + ">";
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
