The following README file is presenting a small description of the features the CLI program is capable and how to interact with it.

-----------------MAIN FEATURES-----------------
The program does the following:
-It takes as a sourse input to be parsed a text file or an webpage.
-It receives from user how many words to be written into .png image.
-It takes .png image name as an input from the user.
-The CLI menu runs in a continuous loop until all user inputs have been given by the user.
-It starts running the parsing & creating the word cloud image automatically as soon as all user inputs are provided.
-It detects which alghorithm to run (file parser or webpage parser) based on user input without the user having to set up which alghorithm to run.

-----------------HOW TO-----------------
The WordCloud image creation program:
*************George-Alexandru Craciun

#################################
#     Word Cloud Application    #
#################################
(1) File name you want to parse (file OR url)
(2) Max. number of words to be displayed
(3) File name of the word cloud image
(4) Quit

!!All the inputs from 1-3 should be provided by pressing the corresponding digit first, to enter in the input waiting mode. 
!!The program will start running the parsing alghorithm automatically only when all the inputs have been provided (menu options [1-3]).

1. File name (.txt) or webpage to be parsed. 
   Valid file names should contain the .txt extension as well (i.e textFileExample.txt).
   Valid webpage inputs should contain https or http protocol at the beginning of the input String (i.e. https://google.com).
2. The number of words to be included in the word cloud image. 
3. The image file name including the .png extension of the word cloud image. The image will be created in the root folder.
4. If menu option no. 4 is chossen, the program will end running and an "Application closed" message will be printed in the console.

!!If an invalid menu option (out of the range [1-4]) will be chosen, the program will detect that and ask the user to enter a valid option again.
