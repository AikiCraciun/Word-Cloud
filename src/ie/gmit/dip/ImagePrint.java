package ie.gmit.dip;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * Provides the functionality of creating the word cloud image of the desired user input source.
 * 
 * @author AlexCraciun
 * @version 1.0
 * @since 1.8
 *
 */

public class ImagePrint {
	private String imageFileName;
	
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 65);
	
	private String[] fontFamilies = {"SansSerif", "Serif", "Monospaced"};
	private int[] styleConstants = {0, 1, 2};
	private Color[] colors = {Color.blue, Color.gray, Color.green, Color.yellow, Color.red, Color.pink, Color.magenta, Color.black};

	private int fontIncrement = 2;
	private int verticalIncrement = 45;
	private int indentationIncrement = 15;

	/**
	 * The ImagePrint class constructor.
	 * 
	 * @param imageFileName The word cloud image file name.
	 */
	public ImagePrint(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * Generates the creation of word cloud image and saves the image file.
	 * Implements a randomness for font colors, font families etc. for each word in the array.
	 * 
	 * @param words The String[] of words to be included in the word cloud image.
	 * @throws IOException
	 */
	public void createImage(String[] words) throws IOException {
		int fontSize = 65;
		
		int firstColumnIndentation = 10;
		int secondColumnIndentation = 450;
		
		int verticalDist = 60;

		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_4BYTE_ABGR);

		Graphics graphics = image.getGraphics();

		for (int i=0; i < words.length; i++) {
			int fontFamilyIndex = (int) (Math.random() * fontFamilies.length);
			String fontFamily = fontFamilies[fontFamilyIndex];
				
			int styleConstant = (int) (Math.random() * styleConstants.length);
			
			font = new Font(fontFamily, styleConstant, fontSize);
			
			graphics.setFont(font);
			
			if(((i+1) % 2) == 0) {
				writeWord(words, graphics, font, verticalDist, firstColumnIndentation, secondColumnIndentation, fontSize, i);
				verticalDist = verticalDist + this.verticalIncrement;
				secondColumnIndentation = secondColumnIndentation + indentationIncrement;
			}
			if(((i+1) % 2) == 1) {
				writeWord(words, graphics, font, verticalDist, firstColumnIndentation, secondColumnIndentation, fontSize, i);
				firstColumnIndentation = firstColumnIndentation + indentationIncrement;
			}
			fontSize = fontSize - this.fontIncrement;
		}
		graphics.dispose();
		ImageIO.write(image, "png", new File(this.imageFileName));
	}
	
	private void writeWord(String[] words, 
					   Graphics graphics, 
					   Font font, 
					   int verticalDist, 
					   int firstColumnIndentation, 
					   int secondColumnIndentation, 
					   int fontSize, int i) {
		if(((i+1) % 2) == 0) {
			Color randomColor = colors[(int) (Math.random() * colors.length)];
			graphics.setColor(randomColor);
			graphics.setFont(font);
			graphics.drawString(words[i], secondColumnIndentation, verticalDist);
		}
		if(((i+1) % 2) == 1) {
			Color randomColor = colors[(int) (Math.random() * colors.length)];
			graphics.setColor(randomColor);
			graphics.setFont(font);
			graphics.drawString(words[i], firstColumnIndentation, verticalDist);
		}	
	}

}
