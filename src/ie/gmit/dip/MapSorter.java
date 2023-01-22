package ie.gmit.dip;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The class MapSorter provides the sorting functionality of a Map<String, Iteger> based
 * on the Integer value. 
 * 
 * @author AlexandruCraciun
 * @version 1.0
 * @since 1.8
 */
public class MapSorter {

	/**
	 * Provides the sorting functionality of an unsorted map into an sorted map based on 
	 * Integer values.
	 * 
	 * @param unsortMap The unsorted map upon which the sorting need to done.
	 * @return The sorted HashMap<String, Integer> based on Integer values. 
	 */
	public static HashMap<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
