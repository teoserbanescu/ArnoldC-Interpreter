package IfNodes;

import visitor.Visitor;
import AbstractSyntaxTree.ASTNode;

public class IfBodyNode extends ASTNode {
	
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return "IfBodyNode";
	}
}
