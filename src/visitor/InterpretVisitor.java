package visitor;

import java.io.IOException;
import java.io.PrintWriter;

import AbstractSyntaxTree.*;
import IfNodes.*;
import NumbLeafNodes.*;
import StatementNodes.AssignmentNode;
import StatementNodes.DeclareNode;
import ValueNodes.*;
import WhileNodes.WhileBodyNode;
import WhileNodes.WhileNode;

/**
 * Interprets the AST
 * Visits all its nodes
 * @author teodora
 *
 */

public class InterpretVisitor implements Visitor {
	PrintWriter writer;
	
	public InterpretVisitor(String interpretFile) {
		try{
		    writer = new PrintWriter(interpretFile, "UTF-8");
		} catch (IOException e) {
			
		}
	}
	/**
	 * visits all nodes from main and then closes the writer file
	 */
	
	public void visit(MainNode node) {
		for (ASTNode subordinate : node.getSubordinates()) {
			subordinate.accept(this);
		}
		writer.close();
	}
	
	/**
	 * sets lvalNode variable to the value in the right
	 */
	@Override
	public void visit(DeclareNode node) {
		LvalNode leftNode = node.getLvalNode();
		ValueNode rightNode = node.getValueNode();
		VariablesMap.getInstance().put(leftNode.getVariable(), rightNode.getValue());
	}
	/**
	 * prints the corresponding value
	 */
	@Override
	public void visit(PrintNode node) {
		for (ASTNode subordinate : node.getSubordinates()) {
			writer.println(subordinate.output());
		}
	}
	
	/**
	 * Calls subordinates' visit methods so that the right subtree value is calculated
	 * sets lvalNode variable to the value in the right subtree
	 */

	@Override
	public void visit(AssignmentNode node) {
		for (ASTNode subordinate : node.getSubordinates()) {
			subordinate.accept(this);
		}
		LvalNode leftNode = node.getLvalNode();
		ValueNode rightNode = node.getValueNode();
		VariablesMap.getInstance().put(leftNode.getVariable(), rightNode.getValue());
	}
	
	/**
	 * Leaf nodes are not interpreted by the visitor
	 */
	
	@Override
	public void visit(VariableNode node) {
		
	}

	@Override
	public void visit(ConstantNode node) {
	
	}

	@Override
	public void visit(StringNode node) {
		
	}

	@Override
	public void visit(LvalNode node) {
		
	}

	@Override
	public void visit(RvalNode node) {
		
	}
	
	@Override
	public void visit(ConditionNode node) {
		
	}
	
	/**
	 * Verify condition and choose branch(if, else)
	 * if they exist
	 * Treat this by catching an exception
	 */
	
	@Override
	public void visit(IfNode node) {
		ConditionNode condition = node.getConditionNode();
		IfBodyNode ifBody = node.getIfBodyNode();
		ElseBodyNode elseBody = node.getElseBodyNode();
		if (condition.isTrue()) {
			ifBody.accept(this);
		} else {
			try {
				elseBody.accept(this);
			} catch (NullPointerException nullPointerException) {
				/**
				 * Else branch does not exist
				 */
			}
		}
	}
	
	@Override
	public void visit(IfBodyNode node) {
		for (ASTNode subordinate : node.getSubordinates()) {
			subordinate.accept(this);
		}
	}
	@Override
	public void visit(ElseBodyNode node) {
		for (ASTNode subordinate : node.getSubordinates()) {
			subordinate.accept(this);
		}
	}
	
	/**
	 * interpret the body node and visit its components
	 * while condition is true
	 */
	
	@Override
	public void visit(WhileNode node) {
		ConditionNode condition = node.getConditionNode();
		WhileBodyNode whileBody = node.getWhileBodyNode();
		while (condition.isTrue()) {
			whileBody.accept(this);
		}
	}
	
	/**
	 * Interpret the body node
	 */
	@Override
	public void visit(WhileBodyNode node) {
		for (ASTNode subordinate : node.getSubordinates()) {
			subordinate.accept(this);
		}
	}
	/**
	 * visit operation nodes. do the corresponding operation
	 */
	@Override
	public void visit(OperationNode node) {
		for (ASTNode subordinate : node.getSubordinates()) {
			subordinate.accept(this);
		}
		node.doOperation();
	}
}
