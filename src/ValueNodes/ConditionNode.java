package ValueNodes;

import visitor.Visitor;
import AbstractSyntaxTree.VariablesMap;
/**
 * Condition node class
 * Extends ValueNode
 * @author teodora
 *
 */

public class ConditionNode extends ValueNode {
	private String variable;
	
	public ConditionNode(String variable) {
		this.variable = variable;
	}
	
	public boolean isTrue() {
		return this.getValue() > 0;
	}
	
	@Override
	public String toString() {
		return "ConditionNode <" + variable.toString() + ">";
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	@Override
	public Integer getValue() {
		return VariablesMap.getInstance().get(variable);
	}
}
