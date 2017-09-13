package StatementNodes;

import AbstractSyntaxTree.ASTNode;
import NumbLeafNodes.LvalNode;
import ValueNodes.ValueNode;
import visitor.*;

public class AssignmentNode extends ASTNode{
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return "AssignmentNode";
	}
	
	public LvalNode getLvalNode() {
		return (LvalNode) this.getSubordinateAt(0);
	}
	
	public ValueNode getValueNode() {
		return (ValueNode) this.getSubordinateAt(1);
	}
}
