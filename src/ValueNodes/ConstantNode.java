package ValueNodes;

import Parser.Token;
import visitor.Visitor;
/**
 * Constant Node class
 * Contains value
 * @author teodora
 *
 */

public class ConstantNode extends ValueNode {
	private Integer value;
	
	public ConstantNode(Integer value) {
		this.setValue(value);
	}
	/**
	 * Constructor is called with a string value as parameter
	 * If the string value is a number, then that's the value of
	 * the node.
	 * If the string value is one of the keywords for True or False,
	 * the node is 1 or 0.
	 * If the string value is neither of these two, throw
	 * NumberFormatException
	 */
	public ConstantNode(String stringValue) {
		try{
			value = Integer.parseInt(stringValue);
	    }
	    catch(NumberFormatException e){
	    	Token token = Token.get(stringValue);
	    	if (token == null) {
	    		throw new NumberFormatException();
	    	}
	    	switch (token) {
	    	case False:
	    		value = 0;
	    		break;
	    	case True:
	    		value = 1;
	    		break;
	    	default:
	    		throw new NumberFormatException();
	    	}
	    }
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer integerValue) {
		this.value = integerValue;
	}
	/*
	 * for printing the AST
	 * ConstantNode <integer_value>
	 */
	@Override
	public String toString() {
		return "ConstantNode <" + value.toString() + ">";
	}
	
	@Override
	public String output() {
		return value.toString();
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
