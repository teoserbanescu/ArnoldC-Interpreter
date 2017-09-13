package AbstractSyntaxTree;

import visitor.*;

/**
 * Main node class
 * @author teodora
 *
 */

public class MainNode extends ASTNode{

	public void accept(Visitor v) {
		v.visit(this);
	}
	@Override
	public String toString() {
		return "MainNode";
	}
}
