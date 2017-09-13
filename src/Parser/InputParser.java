package Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that contains the BufferedReader
 * for the input file
 * Parses the input, deleting spaces and tabs
 * and skip garbage lines
 * @author teodora
 *
 */

public class InputParser {
	private BufferedReader br;
	public InputParser(String file) {
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * returns the next line that contains a valid instruction
	 * the line is parsed, the additional spaces and tabs
	 * are removed
	 */
	
	public String getNextValidInstruction() {
		try {
			String line = br.readLine();
			if (line == null) {
				return null;
			}
			line = line.trim().replaceAll("\\s{2,}", " ");
			while (Token.getInstruction(line) == null) {
				line = br.readLine();
				if (line == null) {
					return null;
				}
				line = line.trim().replaceAll("\\s{2,}", " ");
			}
			return line;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
