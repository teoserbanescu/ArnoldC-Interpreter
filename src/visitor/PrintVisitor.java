package visitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import AbstractSyntaxTree.*;
import IfNodes.*;
import NumbLeafNodes.*;
import StatementNodes.AssignmentNode;
import StatementNodes.DeclareNode;
import ValueNodes.*;
import WhileNodes.*;
/**
 * 
 *	Prints the AST
 *	All nodes containing childs call the private method
 *	visitSubordinates, which prints the current node
 *	and then calls subordinates' visit methods.
 *	All leaf nodes call the private method visitLeafNode
 *	which prints the current node.
 *	The print is done recursively, using the double dispatch.
 * @author teodora
 */

public class PrintVisitor implements Visitor {
	/**
	 * Keep a private variable tabs, that counts the number of
	 * tabs to print, depending on the current level.
	 */
	private int tabs = -1;
	PrintWriter writer;
	
	public PrintVisitor(String printFile) {
		try{
		    writer = new PrintWriter(printFile, "UTF-8");
		} catch (IOException e) {
			
		}
	}

	@Override
	public void visit(MainNode node) {
		visitSubordinates(node);
		writer.close();
	}

	@Override
	public void visit(PrintNode node) {
		visitSubordinates(node);
	}

	@Override
	public void visit(DeclareNode node) {
		visitSubordinates(node);
	}

	@Override
	public void visit(AssignmentNode node) {
		visitSubordinates(node);
	}

	@Override
	public void visit(VariableNode node) {
		visitLeafNode(node);
	}

	@Override
	public void visit(ConstantNode node) {
		visitLeafNode(node);
	}

	@Override
	public void visit(StringNode node) {
		visitLeafNode(node);
	}

	@Override
	public void visit(LvalNode node) {
		visitLeafNode(node);
	}

	@Override
	public void visit(RvalNode node) {
		visitLeafNode(node);
	}
	
	@Override
	public void visit(ConditionNode node) {
		visitLeafNode(node);
	}
	
	@Override
	public void visit(IfNode node) {
		visitSubordinates(node);
	}
	@Override
	public void visit(IfBodyNode node) {
		visitSubordinates(node);
	}
	@Override
	public void visit(ElseBodyNode node) {
		visitSubordinates(node);
	}
	@Override
	public void visit(WhileNode node) {
		visitSubordinates(node);
	}
	@Override
	public void visit(WhileBodyNode node) {
		visitSubordinates(node);
	}
	
	@Override
	public void visit(OperationNode node) {
		visitSubordinates(node);
	}
	
	/**
	 * print the current node, then print all of its subordinates
	 */
	
	private void visitSubordinates(ASTNode node) {
		++tabs;
		writer.println(repeatChar('\t', tabs) + node);
		for (ASTNode subordinate : node.getSubordinates()) {
			subordinate.accept(this);
		}
		--tabs;
	}
	
	/**
	 * print the current node
	 */
	
	private void visitLeafNode(ASTNode node) {
		++tabs;
		writer.println(repeatChar('\t', tabs) + node);
		--tabs;
	}
	
	/**
	 * Repeats char c for length times
	 * @param c
	 * @param length
	 * @return
	 */
	private String repeatChar(char c, int length) {
	    char[] data = new char[length];
	    Arrays.fill(data, c);
	    return new String(data);
	}

}
