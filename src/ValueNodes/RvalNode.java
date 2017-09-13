package ValueNodes;

import visitor.Visitor;
import AbstractSyntaxTree.VariablesMap;

/**
 * Rval Node Class
 * Extends ValueNode
 * Has the variable as field
 * @author teodora
 *
 */

public class RvalNode extends ValueNode{
	private String variable;
	
	public RvalNode(String variable) {
		this.variable = variable;
	}
	
	@Override
	public String toString() {
		return "RvalNode <" + variable.toString() + ">";
	}
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	/*
	 * get variable's value
	 */
	
	public Integer getValue() {
		return VariablesMap.getInstance().get(variable);
	}
}
