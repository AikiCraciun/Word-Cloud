package ie.gmit.dip;

import java.util.Scanner;

/**
 *Provides the menu display options and user input functionality.
 * 
 * @author AlexCraciun
 * @version 1.0
 * @since 1.8
 *
 */

public class CommandLineUI {
	private Scanner s;
	private int maxNumberOfWords = 0;
	private String imageFileName = null;
	private String fileNameToParse = null;
	private boolean keepRunning = true;

	/**
	 * The constructor initiates the private methods which deals with waiting for 
	 * the user inputs.
	 */
	public CommandLineUI() {
		s = new Scanner(System.in);
		showOptions();
		getUserInput();
	}

	/**
	 * Getter of the user input max. number of words to be displayed.
	 * 
	 * @return 
	 */
	public int getMaxNumberOfWords() {
		return maxNumberOfWords;
	}

	/**
	 * Getter of the image file name.
	 * @return
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * Getter of the source text file name or webpage to be parsed.
	 * @return
	 */
	public String getFileNameToParse() {
		return fileNameToParse;
	}

	private void getUserInput() {
		while (keepRunning) {
			if(imageFileName != null && fileNameToParse != null && maxNumberOfWords != 0) {
				keepRunning = false; 
				break;
			}
			
			System.out.println("Select an option [1-4]");
			
			int choice = Integer.parseInt(s.next()); // Blocking statement;
	
			if (choice == 1) {
				System.out.println("Enter the file name you want to parse >");
				fileNameToParse = s.next();
			} else if (choice == 2) {
				System.out.println("Enter the number of words you want to display in the word cloud > ");
				maxNumberOfWords = Integer.parseInt(s.next());
			} else if (choice == 3) {
				System.out.println("Enter the word cloud image file name desired > ");
				imageFileName = s.next();
			} else if (choice == 4) {
				System.out.println("\nApplication closed.");
				keepRunning = false;
				System.exit(0);
			} else {
				System.out.println("\nIncorrect input option, select option [1-4] > ");
			}
		}
	}

	private void showOptions() {
		System.out.println("#################################");
		System.out.println("#     Word Cloud Application    #");
		System.out.println("#################################");
		System.out.println("(1) File name you want to parse (file OR url).");
		System.out.println("(2) Max. number of words to be displayed.");
		System.out.println("(3) File name of the word cloud image.");
		System.out.println("(4) Quit \n");
	}
}
