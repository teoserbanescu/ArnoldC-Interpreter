package AbstractSyntaxTree;

import visitor.*;

public class PrintNode extends ASTNode {
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		return "PrintNode";
	}
	
}
