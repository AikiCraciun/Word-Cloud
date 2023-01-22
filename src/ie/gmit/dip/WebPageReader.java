package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *The class WebPageReader implements Parser interface. 
 *It parses the webpage provided as an input into an ArrayList of words ignoring other characters 
 *which are not desired to be included. 
 *In order for the webpage URL provided to be a valid input, it needs to include the 
 *protocol (i.e. http or https).
 *To parse the undesired characters, into the regular expresion used to implement
 *this the following list of characters have been utilised <b>!?,;\\:={}<>.'()*+%&$@_/#/\"0-9</b>
 *
 * @author AlexCraciun
 * @version 1.0
 * @since 1.8
 *
 * @see Parser
 */

public class WebPageReader implements Parser {
	private String fileNameToParse;
	
	/**
	 * The constructor of class WebPageReader.
	 * 
	 * @param fileNameToParse  The webpage to parse user input. The user needs to be provide a valid URL string.
	 * Only URL's with the protocol included are valid inputs.
	 */
	
	public WebPageReader(String fileNameToParse) {
		this.fileNameToParse = fileNameToParse;
	}

	/**
	 * The Overriden method parse() from interface Parser.
	 * It takes the URL name provided into the constructor of the object and 
	 * parses the URL into an ArrayList of words ignoring undesired characters.
	 * 
	 */
	
	@Override
	public ArrayList<String> parse() throws FileNotFoundException {
		URL webpage = null;
		URLConnection conn = null;

		ArrayList<String> stringArray = new ArrayList<>();

		try {
			webpage = new URL(this.fileNameToParse);
			conn = webpage.openConnection();
			InputStreamReader reader = new InputStreamReader(conn.getInputStream(), "UTF8");
			BufferedReader buffer = new BufferedReader(reader);

			String line = "";
			while (true) {
				line = buffer.readLine();
				if (line == null) {
					break;
				}
				line = line.replaceAll("[!?,;\\:={}<>.()*+%&$@_/#/\"0-9]", " ");
				String line2 = line.replaceAll("[-]", " ");

				String[] temp = line2.split("\\s+");
				for (String word : temp) {
					String tempString = word.replaceAll("[!?,;\\:={}<>.()@*+%&$_/#/\"0-9]", " ");
					if (!tempString.equals("")) {
						stringArray.add(tempString);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringArray;
	}
}
