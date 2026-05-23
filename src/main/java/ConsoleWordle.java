package assign03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A console game similar to wordle, where the user has six chances to guess a five letter word.
 * 
 * Created for CS 1410-001 ; Assignment 3: Wordle
 * 
 * @author Charles Adair
 * @version September 15, 2023
 */
public class ConsoleWordle {
	
	/**
	 * Main method for playing the word guessing game.
	 *
	 * This method performs the following steps:
	 * 1. Reads words from a file and stores them in an array using the readFile method.
	 * 2. Randomly chooses a word from the array to be the secret word using the getSecretWord method.
	 * 3. Creates a new Scanner object with System.in.
	 * 4. Repeatedly asks the user for a guess using the getUserGuess method and provides feedback on the guess using the displayResultOfRound method until the user's guess completely matches the secret word or six rounds are completed.
	 * 5. Prints a winning message if the user guesses the secret word and a losing message if it is not guessed after six rounds, including revealing the secret word.
	 * 6. Wraps all code in a try-catch block for handling FileNotFoundException thrown by the readFile method and prints a message about not finding the file in the catch part.
	 * 7. Closes the Scanner object created with System.in.
	 * 8. Ends the program after one game, allowing it to be rerun to play again.
	 *
	 * @param args The command-line arguments (not used in this program).
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
	    // Implementation of the main method goes here.
		String[] wordList = readFile("words.txt");
		String randWord = getSecretWord(wordList);
		Scanner userInput = new Scanner(System.in);
		Boolean gameNotWon = true;
		while (gameNotWon) {
			for (int round = 0; round < 6; ++round) {
				System.out.println("Round " + (round + 1) + " -- Enter a word:");
				String guess = getUserGuess(userInput);
				displayResultOfRound(guess, randWord);
				if (guess.equals(randWord)) {
					gameNotWon = false;
					break;
				}
			}
			break;
		}
		if (gameNotWon) {System.out.println("You lose.");}
		else {System.out.println("You win!");}
	}
	
	
	/**
	 * Reads data from a text file and returns it as an array of String elements.
	 *
	 * @param fileName The name of the file to be read.
	 * @return An array of String elements containing the data read from the file.
	 * @throws FileNotFoundException 
	 */
	public static String[] readFile(String fileName) throws FileNotFoundException {
		
		File txtFile = new File(fileName);
		Scanner cyborg = new Scanner(txtFile);
		int fileLength = cyborg.nextInt();
		cyborg.nextLine();
		String[] output = new String[fileLength];
		for (int i = 0; i < fileLength; ++i) {
			output[i] = cyborg.nextLine();
		}
		cyborg.close();
		return output;
	}
	
	
	/**
	 * Selects a random word from an array of String elements and returns it.
	 *
	 * @param words An array of String elements from which to select a random word.
	 * @return A randomly selected word from the input array.
	 */
	public static String getSecretWord(String[] words) {
	    Random randomGen = new Random();
	    int randIndex = randomGen.nextInt(0,words.length);
	    return words[randIndex];
	}
	
	
	/**
	 * Asks the user for a 5-letter word and returns it.
	 *
	 * This method uses the provided Scanner object to get input from the user. It will
	 * repeatedly ask the user for a word until the input contains exactly five lowercase letters.
	 *
	 * @param scanner The Scanner object used to get user input.
	 * @return A 5-letter word entered by the user.
	 */
	public static String getUserGuess(Scanner cyborg) {
		String guess = null;
		boolean notFiveLetters = true;
		while (notFiveLetters) {
			guess = cyborg.next();
			if (guess.length() == 5) {
				notFiveLetters = false;
			}
			else {
				System.out.println("Must be 5 characters in length");
			}
		}
		return guess;
	}
	
	
	/**
	 * Checks if a character matches one of the letters in a given String.
	 *
	 * @param character The character to be checked for a match.
	 * @param word The String in which to search for a matching character.
	 * @return true if the character matches one of the letters in the String, false otherwise.
	 */
	public static boolean letterContainedInWord(char character, String word) {
	    Boolean letterInWord = false;
	    char[] letterArray = word.toCharArray();
	    for (int i = 0; i < 5; i++) {
	    	if (character == letterArray[i]) {
	    		letterInWord = true;
	    		break;
	    	}
	    }
	    return letterInWord;
	}
	
	
	/**
	 * Prints the results of the user's guess for one round.
	 *
	 * This method takes the user's guess and the secret word as input and prints the results of the guess to the console. It compares each letter in the user's guess with the corresponding letter in the secret word and prints the result according to the following rules:
	 *
	 * - If the letter from the user's guess is the same as a letter in the secret word and in the correct place, display the letter capitalized.
	 * - If the letter from the user's guess is the same as a letter in the secret word but not in the correct place, display the letter in its original lowercase form using the letterContainedInWord method.
	 * - If the letter from the user's guess is not in the secret word, display a dash '-'.
	 *
	 * The characters are displayed on the same line, and a newline is printed after processing each letter.
	 *
	 * @param guess The user's guess as a String.
	 * @param secretWord The secret word as a String.
	 */
	
	public static void displayResultOfRound(String guess, String secretWord) {
	    String output = "";
	    char[] guessArray = guess.toCharArray();
	    char[] secretWordArray = secretWord.toCharArray();
	    for (int i = 0; i < 5; i++) {
	    	char currentLetter = guessArray[i];
	    	if (currentLetter == secretWordArray[i]) {
	    		output += Character.toUpperCase(currentLetter);
	    	}
	    	else if (letterContainedInWord(guessArray[i], secretWord)) {
	    		output += Character.toLowerCase(currentLetter);
	    	}
	    	else {
	    		output += '-';
	    	}
	    }
	    System.out.println(output);
	    // You should compare each letter in the guess with the corresponding letter in the secretWord
	    // and print the result following the specified rules.
	}



}
