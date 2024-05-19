package Q1;

import java.util.Random;

//The game's vocabulary
public class Vocabulary {
	private static String[] vocabulary = { "convert", "strain", "vegetable", "deposit", "theme", "missile", "guilt",
			"kettle", "force", "system", "wife", "concede", "equation", "fragment", "contain", "perfume", "survey",
			"jail", "seasonal", "offense", "manage", "raise", "retire", "praise", "adult", "rocket", "wear",
			"available", "courtesy", "earthwax" };

	// Random selection of a word from a word pool
	public static String getRandomWord() {
		Random rnd = new Random();
		return vocabulary[rnd.nextInt(vocabulary.length)];
	}
}
