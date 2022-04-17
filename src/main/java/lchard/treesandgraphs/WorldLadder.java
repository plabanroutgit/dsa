package lchard.treesandgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

//https://www.youtube.com/watch?v=ZVJ3asMoZ18

public class WorldLadder {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}

		int len = beginWord.length();
		Map<String, List<String>> map = new HashMap<>();
		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String wordTemp = word.substring(0, i) + "*" + word.substring(i + 1, len);
				List<String> words = map.getOrDefault(wordTemp, new ArrayList<>());
				words.add(word);
				map.put(wordTemp, words);
			}
		}

		Queue<Pair<String, Integer>> queue = new LinkedList<>();
		Map<String, Boolean> visited = new HashMap<>();
		queue.add(new Pair(beginWord, 1));
		visited.put(beginWord, true);
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			Pair<String, Integer> current = queue.poll();
			String currentWord = current.getKey();
			for (int i = 0; i < currentWord.length(); i++) {
				String wordTemp = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, len);
				List<String> words = map.getOrDefault(wordTemp, new ArrayList<>());
				for (String matchWord : words) {
					if (matchWord.equals(endWord)) {
						return current.getValue() + 1;
					}
					if (!visited.containsKey(matchWord)) {
						visited.put(matchWord, true);
						queue.add(new Pair(matchWord, current.getValue() + 1));
					}
				}
			}

		}
		return 0;
	}

	public static void main(String[] args) {

		String start = "hit";
		String end = "cog";

		String[] worddict = { "hot", "dot", "dog", "lot", "log", "cog" };

		List<String> dict = new LinkedList<String>();

		dict.addAll(Arrays.asList(worddict));

		System.out.println(ladderLength(start, end, dict));

	}

}