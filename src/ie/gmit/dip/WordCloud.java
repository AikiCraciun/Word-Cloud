package ie.gmit.dip;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *The class WordCloud is the main class in the WordCloud program which 
 *has dependencies to other secondary implementation classes for WordCloud program.
 *
 * @author AlexCraciun
 * @version 1.0
 * @since 1.8
 *
 *@see ArrayListFileReader 
 *@see WebPageReader 
 *@see FrequencyTable 
 *@see ArrayListFileReader
 *
 */

public class WordCloud {
	private static ArrayListFileReader fileParser;
	private static WebPageReader webParser;
	private static FrequencyTable frequencyTable = new FrequencyTable();
	private static ArrayListFileReader ignoreWordsFile;
	
	private String imageFileName;
	private int maxNumberOfWords;
	private String fileNameToParse;
	
	
	/**
	 * The constructor of the WordCloud object.
	 * 
	 * @param fileNameToParse The file name to parse user input. The user needs to be provide a valid file path.
	 * Only <b>.txt files</b> can be parsed.
	 * @param maxNumberOfWords The max. number of words used to include into image file.
	 * @param imageFileName The image file name used to generate image file.
	 */
	public WordCloud(String fileNameToParse, int maxNumberOfWords, String imageFileName) {
		fileParser = new ArrayListFileReader(fileNameToParse);
		webParser = new WebPageReader(fileNameToParse);
		ignoreWordsFile = new ArrayListFileReader("./ignorewords.txt");
		this.imageFileName = imageFileName;
		this.maxNumberOfWords = maxNumberOfWords;
		this.fileNameToParse = fileNameToParse;
	}
	
	private HashMap<String, Integer> removeIgnoreWords() throws FileNotFoundException {
		if (this.fileNameToParse.contains("https") || this.fileNameToParse.contains("http") 
			|| this.fileNameToParse.contains("www")) {
			return parseURL();
		} else {
			return parseFile();
		}
	}
	
	private HashMap<String, Integer> parseURL() throws FileNotFoundException {
		frequencyTable.countWords(webParser.parse());
		HashMap<String, Integer> map = frequencyTable.getTable();
	
		ArrayList<String> ignoreWordsStringArray = ignoreWordsFile.parse();
		
		for (String ignoreWord : ignoreWordsStringArray) {
			if (map.containsKey(ignoreWord)) {
				map.remove(ignoreWord);
			}
		}
		return map;
	}
	
	private HashMap<String, Integer> parseFile() throws FileNotFoundException  {
		frequencyTable.countWords(fileParser.parse());
		HashMap<String, Integer> map = frequencyTable.getTable();
	
		ArrayList<String> ignoreWordsStringArray = ignoreWordsFile.parse();
		
		for (String ignoreWord : ignoreWordsStringArray) {
			if (map.containsKey(ignoreWord)) {
				map.remove(ignoreWord);
			}
		}
		return map;
	}
	
	private HashMap<String, Integer> getSortedMap() throws FileNotFoundException {
		HashMap<String, Integer> unsortedMap = removeIgnoreWords();
		return MapSorter.sortByValue(unsortedMap);
	}
	
	/**
	 * Creates and saves a word cloud image with the number of words provided as an input.
	 * The location in the file system the image file is created it's in the root directory.
	 * 
	 * @param imageFileName The image file name used to generate image file.
	 * @param maxNumberOfWords The max. number of words used to include into image file.
	 * @throws IOException 
	 */
	
	public void printWordCloudImage(String imageFileName, int maxNumberOfWords) throws IOException {
		ImagePrint image = new ImagePrint(imageFileName);
		
		HashMap<String, Integer> sortedMap = getSortedMap();
		Object[] wordsArray = sortedMap.keySet().toArray();
		String[] subArray = Arrays.copyOf(wordsArray, maxNumberOfWords, String[].class);
		image.createImage(subArray);	
	}
}
