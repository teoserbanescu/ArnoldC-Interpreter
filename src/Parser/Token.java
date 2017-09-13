package Parser;

import Utils.Pair;
/**
 * Enum where Tokens and their values are stored
 * A token is an instruction from the Java language
 * and the keyword is the corresponding instruction in
 * the ArnoldC language
 * @author teodora
 *
 */

public enum Token {
	
	False("@I LIED"),
	True("@NO PROBLEMO"), 
	If("BECAUSE I'M GOING TO SAY PLEASE"),
	Else("BULLSHIT"),
	EndIf("YOU HAVE NO RESPECT FOR LOGIC"),
	While("STICK AROUND"),
	EndWhile("CHILL"),
	PlusOperator("GET UP"),
	MinusOperator("GET DOWN"),
	MultiplicationOperator("YOU'RE FIRED"),
	DivisionOperator("HE HAD TO SPLIT"),
	ModuloOperator("I LET HIM GO"),
	EqualTo("YOU ARE NOT YOU YOU ARE ME"),
	GreaterThan("LET OFF SOME STEAM BENNET"),
	Or("CONSIDER THAT A DIVORCE"),
	And("KNOCK KNOCK"),
	DeclareInt("HEY CHRISTMAS TREE"),
	SetInitialValue("YOU SET US UP"),
	BeginMain("IT'S SHOWTIME"),
	EndMain("YOU HAVE BEEN TERMINATED"),
	Print("TALK TO THE HAND"),
	AssignVariable("GET TO THE CHOPPER"),
	SetValue("HERE IS MY INVITATION"),
	EndAssignVariable("ENOUGH TALK");
	
    private final String keyword;

    private Token(String keyword) {
        this.keyword = keyword;
    }

    public final String getKeyword() {
        return keyword;
    }
    
    public static Token get(String keyword) {
    	for (Token token : Token.values()) {
    		if (keyword.equals(token.getKeyword())) {
    			return token;
    		}
    	}
    	return null;
    }
    
    public static Pair<Token, String> getInstruction(String line) {
    	for (Token token : Token.values()) {
    		if (line.startsWith(token.getKeyword())) {
    			String argument = 
    					line.replace(token.getKeyword(), "").replaceFirst(" ", "");
    			return new Pair<Token, String>(token, argument);
    		}
    	}
    	return null;
    }
}
