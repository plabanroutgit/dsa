package lcmedium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		List<List<String>> ga = groupAnagrams(strs);

		for (int i = 0; i < ga.size(); i++) {
			System.out.println(ga.get(i));
		}

	}
}