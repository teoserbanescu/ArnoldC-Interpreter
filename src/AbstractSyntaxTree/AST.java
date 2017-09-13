package AbstractSyntaxTree;

import NumbLeafNodes.*;
import Parser.*;
import StatementNodes.*;
import Utils.Pair;
import ValueNodes.*;
import IfNodes.*;
import WhileNodes.*;

/**
 * Class containing the AST
 * Has getter for the root node
 * builds the AST by parsing the input file
 * @author teodora
 *
 */

public class AST {
	private InputParser parser;
	private ASTNode currentNode;
	private ASTNode rootNode;
	
	public AST(String file) {
		parser = new InputParser(file);
	}
	
	public void buildAST() {
		String line = parser.getNextValidInstruction();
		interpretInstruction(line);
		line = parser.getNextValidInstruction();
	}
	
	private void interpretInstruction(String line) {
		Pair<Token, String> instruction = Token.getInstruction(line);
		Token token = instruction.getFirst();
		String argument = instruction.getSecond();
		switch (token) {
		case BeginMain:
			buildMainNode();
			break;
		case Print:
			buildPrintNode(argument);
			break;
		case DeclareInt:
			buildDeclareNode(argument);
			break;
		case SetInitialValue:
			buildValueLeafNode(argument);
			break;
		case AssignVariable:
			buildAssignmentNode(argument);
			break;
		case SetValue:
			buildValueLeafNode(argument);
			break;
		case If:
			buildIfNode(argument);
			break;
		case While:
			buildWhileNode(argument);
			break;
			
		case Or:
		case And:
		case PlusOperator:
		case MinusOperator:
		case MultiplicationOperator:
		case DivisionOperator:
		case ModuloOperator:
		case EqualTo:
		case GreaterThan:
			buildArithmeticNode(line);
			break;
		default:
			break;
		}
	}
	
	private void buildMainNode() {
		ASTNode mainNode = new MainNode();
		rootNode = mainNode;
		currentNode = rootNode;
		String line = parser.getNextValidInstruction();
		while (!line.equals(Token.EndMain.getKeyword())) {
			interpretInstruction(line);
			line = parser.getNextValidInstruction();
		}
	}
	
	private void buildPrintNode(String argument) {
		ASTNode printNode = new PrintNode();
		//interpret argument
		try{
			printNode.addSubordinate(new ConstantNode(argument));
			//it worked
	    }
	    catch(NumberFormatException e){
	    	//it failed
	    	if (argument.indexOf("\"") != -1) {
	    		printNode.addSubordinate(new StringNode(argument.replace("\"", "")));
	    	} else {
	    		printNode.addSubordinate(new VariableNode(argument));
	    	}
	    }
		currentNode.addSubordinate(printNode);
	}
	
	private void buildDeclareNode(String argument) {
		ASTNode declareNode = new DeclareNode();
		declareNode.addSubordinate(new LvalNode(argument));
		//read next line: YOU SET US UP @VALUE or YOU SET US UP INT_VALUE
		currentNode.addSubordinate(declareNode);
		currentNode = declareNode;
		String line = parser.getNextValidInstruction();
		interpretInstruction(line);
		currentNode = currentNode.getParent();
	}
	
	private void buildAssignmentNode(String argument) {
		ASTNode assignmentNode = new AssignmentNode();
		currentNode.addSubordinate(assignmentNode);
		assignmentNode.addSubordinate(new LvalNode(argument));
		
		//go to the assignment node
		currentNode = assignmentNode;
		String line = parser.getNextValidInstruction();
		while (!line.equals(Token.EndAssignVariable.getKeyword())) {
			interpretInstruction(line);
			line = parser.getNextValidInstruction();
		}
		currentNode = currentNode.getParent();
	}
	
	private void buildValueLeafNode(String argument) {
		try {
			currentNode.addSubordinate(new ConstantNode(argument));
		} catch(NumberFormatException e) {
			currentNode.addSubordinate(new RvalNode(argument));
		}
	}
	
	private void buildIfNode(String argument) {
		ASTNode ifNode = new IfNode();
		ifNode.addSubordinate(new ConditionNode(argument));
		ifNode.addSubordinate(new IfBodyNode());
		currentNode.addSubordinate(ifNode);
		currentNode = ifNode.getSubordinates().get(1);
		String line = parser.getNextValidInstruction();
		while (!line.equals(Token.EndIf.getKeyword())) {
			interpretInstruction(line);
			line = parser.getNextValidInstruction();
			if (line.equals(Token.Else.getKeyword())) {
				buildElseBodyNode();
				line = parser.getNextValidInstruction();
			}
		}
		currentNode = currentNode.getParent().getParent();
	}
	
	/*
	 * create elsebody and enter it
	 */
	
	private void buildElseBodyNode() {
		currentNode = currentNode.getParent();
		currentNode.addSubordinate(new ElseBodyNode());
		currentNode = currentNode.getSubordinates().get(2);
	}
	
	private void buildWhileNode(String argument) {
		ASTNode whileNode = new WhileNode();
		whileNode.addSubordinate(new ConditionNode(argument));
		whileNode.addSubordinate(new WhileBodyNode());
		currentNode.addSubordinate(whileNode);
		//go to whilebody
		currentNode = whileNode.getSubordinates().get(1);
		String line = parser.getNextValidInstruction();
		while (!line.equals(Token.EndWhile.getKeyword())) {
			interpretInstruction(line);
			line = parser.getNextValidInstruction();
		}
		currentNode = currentNode.getParent().getParent();
	}
	
	private void buildArithmeticNode(String line) {
		Pair<Token, String> instruction = Token.getInstruction(line);
		Token token = instruction.getFirst();
		String argument = instruction.getSecond();
		ASTNode arithmeticNode = null;
		switch (token) {
		case Or:
			arithmeticNode = new OrNode();
			break;
		case And:
			arithmeticNode = new AndNode();
			break;
		case PlusOperator:
			arithmeticNode = new SumNode();
			break;
		case MinusOperator:
			arithmeticNode = new DifferenceNode();
			break;
		case MultiplicationOperator:
			arithmeticNode = new MultiplicationNode();
			break;
		case DivisionOperator:
			arithmeticNode = new DivisionNode();
			break;
		case ModuloOperator:
			arithmeticNode = new ModuloNode();
			break;
		case EqualTo:
			arithmeticNode = new EqualToNode();
			break;
		case GreaterThan:
			arithmeticNode = new GreaterThanNode();
			break;
		default:
			break;
		}
		
		//delete the right subtree from the list of subordinates and add the arithmetic node
		ASTNode rvalNode = currentNode.getSubordinates().remove(1);
		currentNode.addSubordinate(arithmeticNode);
		
		//the previous right subtree will become arithmetic node's left subtree
		arithmeticNode.addSubordinate(rvalNode);
		currentNode = arithmeticNode;
		buildValueLeafNode(argument);
		currentNode = currentNode.getParent();
	}
	
	public ASTNode getRootNode() {
		return rootNode;
	}
}
