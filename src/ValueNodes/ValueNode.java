package ValueNodes;

import AbstractSyntaxTree.ASTNode;

/**
 * Value Node Class
 * Parent class for all nodes containing values
 * @author teodora
 *
 */
public class ValueNode extends ASTNode{
	private Integer value;

	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public void setValue(Boolean value) {
		this.value = value ? 1 : 0;
	}
}
