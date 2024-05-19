package Q1;

import java.util.Scanner;

//Starts the game Starts a new game with the winning player also picks up the user's letters and shows him if an illegal choice was made
public class Game {
	private boolean win;
	private Word word;
	private String str;
	private Scanner sc = new Scanner(System.in);

	public Game() {
		this.win = false;
		this.str = "";
		this.word = new Word(Vocabulary.getRandomWord());
	}

	// Captures the actions of the user and if he finishes if the game starts a new
	// game
	public void start() {
		System.out.println("Welcome to the guessing game, you have to guess one letter at a time,"
				+ " to win you have to guess all the letters of the word.");
		System.out.println("To exit at any time, enter 'end game'");
		while (!str.equals("end game")) {
			if (win) {
				System.out.printf("You guessed it right! The word is: " + word.getWord() + ". It took you "
						+ word.getNumbOfGuesses() + " guesses.");
				word.newWord(Vocabulary.getRandomWord());
				win = false;
			}
			String availableChars = word.getAvailableCharacters();
			System.out.printf("%n" + word.getWordWithUnderscores() + "%n");
			System.out.println("The available characters are: " + availableChars);
			System.out.print("Try to guess the word. Enter a character: ");
			str = sc.nextLine();

			if (str.equals("end game")) {
				continue;
			}
			if (str.length() != 1) {
				System.out.println("Error - enter exactly one character.");
				continue;
			}
			char inputChar = str.charAt(0);
			if (str.length() != 1 || inputChar < 'a' || inputChar > 'z' || availableChars.indexOf(inputChar) == -1) {
				System.out.println("Error - enter a lowercase english character that wasn't chosen before.");
				continue;
			}
			win = word.newLetter(inputChar);
		}
	}

}
