package IfNodes;

import AbstractSyntaxTree.ASTNode;
import visitor.Visitor;
import ValueNodes.ConditionNode;

/**
 * IfNode Class
 * Extends ASTNode
 * @author teodora
 *
 */

public class IfNode extends ASTNode {
	
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public ConditionNode getConditionNode() {
		return (ConditionNode) this.getSubordinateAt(0);
	}
	
	public IfBodyNode getIfBodyNode() {
		return (IfBodyNode) this.getSubordinateAt(1);
	}
	/**
	 * Returns the else body node if it has one,
	 * otherwise it returns null
	 * @return
	 */
	public ElseBodyNode getElseBodyNode() {
		try {
			return (ElseBodyNode) this.getSubordinateAt(2);
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		}
	}
	
	
	@Override
	public String toString() {
		return "IfNode";
	}
}
