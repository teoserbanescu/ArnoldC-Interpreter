package NumbLeafNodes;

import visitor.Visitor;
import AbstractSyntaxTree.*;

/**
 * Variable Node class
 * Contains the variable name
 * @author teodora
 *
 */

public class VariableNode extends ASTNode {
	protected String variable;
	public VariableNode(String variable) {
		this.setVariable(variable);
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	/*
	 * for printing the AST
	 * VariableNode <variable>
	 */
	@Override
	public String toString() {
		return "VariableNode <" + variable.toString() + ">";
	}
	
	@Override
	public String output() {
		return VariablesMap.getInstance().get(variable).toString();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
