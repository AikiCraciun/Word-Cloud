package ie.gmit.dip;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Interface for implementing in concrete classes which deals 
 * with parsing web and text sources for words included in the source.
 * 
 * @author AlexCraciun
 * @version 1.0
 * @since 1.8
 *
 */

public interface Parser {
	/**
	 * Provides parsing the source functionality.
	 * 
	 * @return ArrayList<String> of words to be returned after parsing the source.
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> parse() throws FileNotFoundException ;
}
