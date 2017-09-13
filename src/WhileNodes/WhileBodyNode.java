package WhileNodes;

import visitor.Visitor;
import AbstractSyntaxTree.ASTNode;
/**
 * While Body class
 * @author teodora
 *
 */

public class WhileBodyNode extends ASTNode {
	
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return "BodyNode";
	}
}