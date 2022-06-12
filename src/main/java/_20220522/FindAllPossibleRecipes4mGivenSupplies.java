package _20220522;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllPossibleRecipes4mGivenSupplies {

	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

		Map<String, Boolean> recipesMap = new HashMap<String, Boolean>();
		for (String r : recipes) {
			recipesMap.put(r, false);
		}

		Map<String, List<String>> ingMap = new HashMap<String, List<String>>();
		for (int i = 0; i < recipes.length; i++) {
			List<String> s = new LinkedList<String>();
			for (String ing : ingredients.get(i)) {
				s.add(ing);
			}
			ingMap.put(recipes[i], s);
		}

		List<String> res = new LinkedList<String>();

		List<String> supList = Arrays.asList(supplies);
		for (int i = 0; i < recipes.length; i++) {

			if (dfs(recipes[i], recipesMap, ingMap, supList)) {
				res.add(recipes[i]);
			}
		}

		return res;
	}

	boolean dfs(String ing, Map<String, Boolean> recipesMap, Map<String, List<String>> ingMap, List<String> supList) {

		if (!supList.contains(ing)) {
			if (recipesMap.get(ing) != null) {
				if (!recipesMap.get(ing)) {
					if (ingMap.get(ing) == null) {
						return false;
					}
					for (String string : ingMap.get(ing)) {
						if (dfs(string, recipesMap, ingMap, supList)) {
							recipesMap.put(string, true);
						} else {
							return false;
						}

					}
				}

			} else {
				recipesMap.put(ing, false);
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {

		String[] recipes = { "bread", "sandwich", "burger" };

		List<List<String>> ingredients = new ArrayList<List<String>>();
		List<String> tmp = new LinkedList<String>();
		tmp.add("yeast");
		tmp.add("flour");

		ingredients.add(tmp);

		tmp = new LinkedList<String>();
		tmp.add("bread");
		tmp.add("meat");
		ingredients.add(tmp);

		tmp = new LinkedList<String>();
		tmp.add("sandwich");
		tmp.add("meat");
		tmp.add("bread");
		tmp.add("salt");
		ingredients.add(tmp);

		String[] supplies = { "yeast", "flour", "meat" };

		FindAllPossibleRecipes4mGivenSupplies rec = new FindAllPossibleRecipes4mGivenSupplies();
		System.out.println(rec.findAllRecipes(recipes, ingredients, supplies));

	}

}
