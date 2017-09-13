package NumbLeafNodes;

import visitor.Visitor;
import AbstractSyntaxTree.ASTNode;
/**
 * String Node class
 * @author teodora
 *
 */

public class StringNode extends ASTNode {
	private String string;
	
	public StringNode(String string) {
		this.string = string;
	}
	/*
	 * For printing the AST
	 * StringNode <string>
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StringNode <" + string + ">";
	}
	
	public String output() {
		return string;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
