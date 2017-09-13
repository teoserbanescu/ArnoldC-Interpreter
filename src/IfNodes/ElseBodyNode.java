package IfNodes;

import visitor.Visitor;
import AbstractSyntaxTree.ASTNode;

public class ElseBodyNode extends ASTNode {
	
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return "ElseBodyNode";
	}
}
