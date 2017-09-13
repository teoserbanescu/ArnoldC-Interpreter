package AbstractSyntaxTree;

import java.util.ArrayList;
import java.util.List;

import visitor.*;

public class ASTNode implements Visitable{
	
	private List<ASTNode> subordinates;
	private ASTNode parent;
	
	public ASTNode() {
		subordinates = new ArrayList<ASTNode>();
	}
	
	public void accept(Visitor v) {
		this.accept(v);
	}
	
	public void addSubordinate(ASTNode nodeToAdd) {
		nodeToAdd.setParent(this);
		subordinates.add(nodeToAdd);
	}

	public List <ASTNode> getSubordinates() {
		return subordinates;
	}
	
	public ASTNode getSubordinateAt(int index) {
		try {
			return subordinates.get(index);
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		}
	}

	public void setSubordinates(List <ASTNode> subordinates) {
		this.subordinates = subordinates;
	}

	public ASTNode getParent() {
		return parent;
	}

	public void setParent(ASTNode parent) {
		this.parent = parent;
	}
	
	public String output() {
		return this.output();
	}
	
}
