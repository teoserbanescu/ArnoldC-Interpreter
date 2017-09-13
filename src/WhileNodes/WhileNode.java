package WhileNodes;

import ValueNodes.ConditionNode;
import visitor.Visitor;
import AbstractSyntaxTree.ASTNode;

/**
 * While Node class
 * Has a condition node and a body node
 * @author teodora
 *
 */

public class WhileNode extends ASTNode {
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public ConditionNode getConditionNode() {
		return (ConditionNode) this.getSubordinateAt(0);
	}
	
	public WhileBodyNode getWhileBodyNode() {
		return (WhileBodyNode) this.getSubordinateAt(1);
	}
	
	@Override
	public String toString() {
		return "WhileNode";
	}
}