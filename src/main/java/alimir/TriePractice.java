package alimir;

import java.util.HashMap;
import java.util.Map;

class TrieNode1 {
	boolean isWord;
	Map<Character, TrieNode1> childrenMap = new HashMap<Character, TrieNode1>();
}

public class TriePractice {

	private TrieNode1 root;

	public TriePractice() {
		this.root = new TrieNode1();
	}

	private void insert(String word) {

		TrieNode1 cur = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (cur.childrenMap.get(c) == null) {
				cur.childrenMap.put(c, new TrieNode1());
			}
			cur = cur.childrenMap.get(c);
		}
		cur.isWord = true;
	}

	private boolean search(String word) {

		TrieNode1 cur = root;

		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);
			if (cur.childrenMap.get(c) == null) {
				return false;
			}
			cur = cur.childrenMap.get(c);

		}

		return cur.isWord;
	}

	private boolean isPrefix(String prefix) {

		TrieNode1 cur = root;

		for (int i = 0; i < prefix.length(); i++) {

			char c = prefix.charAt(i);
			if (cur.childrenMap.get(c) == null) {
				return false;
			}
			cur = cur.childrenMap.get(c);

		}

		return true;
	}
}
