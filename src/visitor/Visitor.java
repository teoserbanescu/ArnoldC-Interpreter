package visitor;

import AbstractSyntaxTree.*;
import IfNodes.*;
import NumbLeafNodes.*;
import StatementNodes.AssignmentNode;
import StatementNodes.DeclareNode;
import ValueNodes.*;
import WhileNodes.*;

public interface Visitor {
	public void visit(MainNode node);
	public void visit(PrintNode node);
	public void visit(DeclareNode node);
	public void visit(AssignmentNode node);
	/*
	 * leaf nodes
	 */
	public void visit(VariableNode node);
	public void visit(ConstantNode node);
	public void visit(StringNode node);
	public void visit(LvalNode node);
	public void visit(RvalNode node);
	public void visit(ConditionNode node);
	/*
	 * if nodes
	 */
	public void visit(IfNode node);
	public void visit(IfBodyNode node);
	public void visit(ElseBodyNode node);
	
	/*
	 * while nodes
	 */
	
	public void visit(WhileNode node);
	public void visit(WhileBodyNode node);
	
	/*
	 * operation nodes
	 */
	public void visit(OperationNode node);
	/*public void visit(AndNode node);
	public void visit(DifferenceNode node);
	public void visit(DivisionNode node);
	public void visit(ModuloNode node);
	public void visit(MultiplicationNode node);
	public void visit(OrNode node);
	public void visit(SumNode node);
	public void visit(EqualToNode node);
	public void visit(GreaterThanNode node);*/
	/*public void visit(ASTNode node);
	public void visit(LeafNode node);*/
	
}
