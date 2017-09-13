package AbstractSyntaxTree;

import java.util.HashMap;

/**
 * VariablesMap class
 * Has a hashmap containing all variables and their values
 * Using singleton pattern so that the variables can
 * be updated from anywhere
 * @author teodora
 *
 */

public class VariablesMap {
	
   private static VariablesMap instance = new VariablesMap();
   
   private HashMap<String, Integer> variables;
   /**
    * make the constructor private so that this class cannot be
    * instantiated
    */
   private VariablesMap() {
	   variables = new HashMap<String, Integer>();
   }
   
   public static VariablesMap getInstance() {
      return instance;
   }
   /**
    * Sets the variable key to the new value
    * @param key
    * @param value
    */
   public void put(String key, Integer value) {
	   variables.put(key, value);
   }
   /**
    * get value of variable key
    * @param key
    * @return
    */
   public Integer get(String key) {
	   return variables.get(key);
   }
}
