package ie.gmit.dip;

import java.io.IOException;

/**
 *Provides the runner class of the WordCloud Application.
 * 
 *@author AlexCraciun
 *@version 1.0
 *@since 1.8
 *
 *@see CommandLineUI, WordCloud
 */

public class Runner {
	public static void main(String[] args) throws IOException {
		CommandLineUI menu = new CommandLineUI();
		String fileNameToParse = menu.getFileNameToParse();
		String imageFileName = menu.getImageFileName();
		int maxNumberOfWords = menu.getMaxNumberOfWords();
		
		WordCloud wordCloud = new WordCloud(fileNameToParse, maxNumberOfWords, imageFileName);
		
		wordCloud.printWordCloudImage(imageFileName, maxNumberOfWords);
	}
}
