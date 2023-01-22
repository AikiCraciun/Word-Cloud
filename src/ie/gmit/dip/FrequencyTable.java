package ie.gmit.dip;

import java.util.HashMap;
import java.util.List;

/**
 * Creates a frequency table of words present in a source file or webpage. 
 * The frequency table it's implemented as a HashMap<String, Integer> where
 * the Integer values represent the number of times each word is present in the source 
 * file or webpage.
 * 
 * @author AlexCraciun
 * @version 1.0
 * @since 1.8
 *
 */

public class FrequencyTable {
	private HashMap<String, Integer> table = new HashMap<String, Integer>();

	/**
	 * Counts the words in the List<String> provided.
	 * 
	 * @param words List<String> of words which counting is based on.
	 */
	@SuppressWarnings("deprecation")
	public void countWords(List<String> words) {
		for (String word : words) {
			String lcWord = word.toLowerCase();

			int frequency = 1;
			if (table.containsKey(lcWord)) { // O(1) constant time operation
				frequency = table.get(lcWord);
				frequency++;
			}
			table.put(lcWord, new Integer(frequency)); // O(1)
		}
	}

	/**
	 * Getter for the frequency table.
	 * 
	 * @return The frequency table as a HashMap<String, Integer>.
	 */
	public HashMap<String, Integer> getTable() {
		return table;
	}
}
