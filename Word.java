package Q1;

//Does all the operation of the words such as choosing a new word or checking if the letter matches the word
public class Word {
	private String word;
	private boolean[] guessed;
	private boolean[] guessedChars;
	private int numbOfGuesses;
	private static final int NUM_OF_ENGLISH_CHARS = 26;

	// Gets the word automatically selected by game
	public Word(String word) {
		newWord(word);
	}

	// Choosing a new word resets the attempts and the selected letters
	public void newWord(String word) {
		this.word = word;
		this.guessed = new boolean[word.length()];
		this.guessedChars = new boolean[NUM_OF_ENGLISH_CHARS];
		this.numbOfGuesses = 0;
	}

	// Checks if the letter is in the word, if so it shows it and removes its
	// essence that is left to guess
	public boolean newLetter(char c) {
		numbOfGuesses += 1;
		int numbOfCharGuesses = 0;
		int numChar = (int) (c - 'a');
		guessedChars[numChar] = true;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				guessed[i] = true;
			}
			if (guessed[i]) {
				numbOfCharGuesses++;
			}
		}
		if (numbOfCharGuesses == guessed.length) {
			return true;
		}
		return false;
	}

	// Returns the selected word
	public String getWord() {
		return word;
	}

	// Returns the number of guesses
	public int getNumbOfGuesses() {
		return numbOfGuesses;
	}

	// Shows what other letters can be used
	public String getAvailableCharacters() {
		String s = "";
		for (int i = 0; i < NUM_OF_ENGLISH_CHARS; i++) {
			if (!guessedChars[i]) {
				s += (char) (i + 'a') + " ";
			}
		}
		return s;
	}

	// Writes the word with underscores (for example dog is _ _ _ )
	public String getWordWithUnderscores() {
		String s = "";
		for (int i = 0; i < guessed.length; i++) {
			if (!guessed[i]) {
				s += "_ ";
			} else
				s += word.charAt(i);
		}
		return s;
	}
}
