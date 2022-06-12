package _20220528;

import java.util.ArrayList;

class Master {

	public int guess(String s) {

		String secret = "acckzz";

		int count = 0;

		for (int i = 0; i < 6; i++) {
			if (secret.charAt(i) == s.charAt(i))
				count++;
		}

		return count;
	}
}
//https://leetcode.com/problems/guess-the-word/discuss/2005696/Java-O(N)-solution-with-explanation
public class GuessTheWord {

	public void findSecretWord(String[] wordlist, Master master) {
		int attempts = 0;
		ArrayList<String> arr = new ArrayList<>();

		for (String s : wordlist) {
			arr.add(s);
		}

		while (attempts < 10) {
			String word = getWord(arr.toArray(new String[arr.size()]));
			int guessVal = master.guess(word);

			if (guessVal == 6)
				return;
			arr.removeIf(str -> helper(str, word) != guessVal); // remove words from word list that dont match current
																// guess value
			attempts++;
		}
	}

	private String getWord(String[] wordlist) {
		int[][] count = new int[wordlist[0].length()][26];

		for (String str : wordlist) { // Store frequencies for every letter in the wordlist here by adding all letter
										// frequencies into a 2d array
			char[] ch = str.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				count[i][ch[i] - 'a']++;
			}
		}

		int highestScore = Integer.MIN_VALUE;
		int score = 0;
		String curr = "";

		for (String str : wordlist) { // Score words based on the letter frequencies
			char[] ch = str.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				score += count[i][ch[i] - 'a'];
			}

			if (score > highestScore) {
				highestScore = score;
				curr = str;
			}

			score = 0;
		}

		return curr;
	}

	private int helper(String s, String t) { // to get the guess value of other words, so if our current guess value is
												// 3 any value != 3 is removed
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				value++;
			}
		}

		return value;
	}

	public static void main(String[] args) {

		String[] wordlist = { "acckzz", "ccbazz", "eiowzz", "abcczz" };

		GuessTheWord gtw = new GuessTheWord();

		gtw.findSecretWord(wordlist, new Master());

	}

}
