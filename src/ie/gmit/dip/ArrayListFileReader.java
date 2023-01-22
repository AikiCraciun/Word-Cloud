package ie.gmit.dip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *ArrayListFileReader implements Parser interface. 
 *It parses the file provided as an input into an ArrayList of words ignoring other characters 
 *which are not desired to be included. 
 *To parse the undesired characters, into the regular expresion used to implement
 *this the following list of characters have been utilised <b>!?,;\\:={}<>.'()*+%&$@_/#/\"0-9</b>.
 *
 *@author AlexCraciun
 *@version 1.0
 *@since 1.8
 *
 *@see Parser
 */

public class ArrayListFileReader implements Parser{
	private String fileNameToParse;
	
	/**
	 * The constructor of class ArrayListFileReader.
	 * 
	 * @param fileNameToParse  the file name to parse user input. The user needs to be provide a valid file path.
	 * Only .txt files can be parsed.
	 */
	public ArrayListFileReader(String fileNameToParse) {
		this.fileNameToParse = fileNameToParse;
	}

	/**
	 * The Overriden method parse() from interface Parser.
	 * It takes the file name provided into the constructor of the object and 
	 * parses the file into an ArrayList of words ignoring undesired characters.
	 * 
	 */
	@Override
	public ArrayList<String> parse() throws FileNotFoundException {
		File file = new File(this.fileNameToParse);  //"./ignorewords.txt"
		Scanner scanner = new Scanner(file);

		ArrayList<String> stringArray = new ArrayList<>();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().replaceAll("[!?,;\\:={}<>.'()*+%&$@_/#/\"0-9]", " ");
			String line2 = line.replaceAll("[-]", " ");
			//String[] temp = scanner.nextLine().split(" ");
			String[] temp = line2.split(" ");
			for (String word: temp) {
				String tempString = word.replaceAll("[!?,;\\:={}<>.()*+%&$@_/#/\"0-9]", " ");
				if(!tempString.equals("")) {
					stringArray.add(tempString);
				}	
			}
		}
		scanner.close();
		return stringArray;
	}
}
