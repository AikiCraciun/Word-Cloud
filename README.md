# Word Cloud

## _Main Features_
The program provides the following features:
* It takes as a sourse input to be parsed a text file or an webpage.
* It receives from user how many words to be written into .png image.
* It takes .png image name as an input from the user.
* The CLI menu runs in a continuous loop until all user inputs have been given by the user.
* It starts running the parsing & creating the word cloud image automatically as soon as all user inputs are provided.
* It detects which alghorithm to run (file parser or webpage parser) based on user input without the user having to set up which alghorithm to run.

## Intructions how to run the program
1. The __repository__ directory should be downloaded locally. 
1. From the repository's __Word-Cloud__ directory, run the following command line instruction 
```
java -jar wcloud.jar
```
3. Once __java -jar wcloud.jar__ command is run form the CLI, the following options should be rendered on screen.

## _Intructions how to use the CLI program_
1. File name you want to parse (file OR url)
1. Max. number of words to be displayed
1. File name of the word cloud image
1. Quit

All the inputs from 1-3 should be provided by pressing the corresponding digit first, to enter in the input waiting mode. 
The program will start running the parsing alghorithm automatically only when all the inputs have been provided (menu options [1-3]).

## _Required Input Format_

1. File name (.txt) or webpage to be parsed. 
   Valid file names should contain the .txt extension as well (i.e textFileExample.txt).
   Valid webpage inputs should contain https or http protocol at the beginning of the input String (i.e. https://google.com).
1. The number of words to be included in the word cloud image. 
1. The image file name including the .png extension of the word cloud image. The image will be created in the root folder.
1. If menu option no. 4 is chossen, the program will end running and an "Application closed" message will be printed in the console.

If an invalid menu option (out of the range [1-4]) will be chosen, the program will detect that and ask the user to enter a valid option again.

## License
GNU General Public License v3.0 

**Free Software, Happy days!**
