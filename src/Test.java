import AbstractSyntaxTree.AST;
import visitor.*;


public class Test {
	
	private static String inputFile, printFile, interpretFile;
	
	/**
	 * Sets filenames: input, printAST, interpretAST
	 * @param inputFileName
	 */
	
	private static void setFileNames(String inputFileName) {
		inputFile = inputFileName;
		printFile = inputFileName.replace(".ac", ".ast");
		printFile = printFile.replace("tests/", "output/");
		interpretFile = inputFileName.replace(".ac", ".out");
		interpretFile = interpretFile.replace("tests/", "output/");
	}
	/**
	 * test AST build and interpretation
	 * @param args args[0] input file name
	 */
	public static void main(String[] args) {
		setFileNames(args[0]);
		AST ast = new AST(inputFile);
		ast.buildAST();
		PrintVisitor printTree = new PrintVisitor(printFile);
		ast.getRootNode().accept(printTree);
		InterpretVisitor interpretTree = new InterpretVisitor(interpretFile);
		ast.getRootNode().accept(interpretTree);
	}
}
