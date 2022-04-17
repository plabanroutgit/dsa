package lcmedium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesDFS {

	public List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		dfs(result, "", n, n);
		return result;
	}

	/*https://www.programcreek.com/2014/01/leetcode-generate-parentheses-java/
	 * left and right represents the remaining number of ( and ) that need to be
	 * added. When left > right, there are more ")" placed than "(". Such cases are
	 * wrong and the method stops.
	 */
	public void dfs(ArrayList<String> result, String s, int left, int right) {
		if (left > right)
			return;

		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}

		if (left > 0) {
			dfs(result, s + "(", left - 1, right);
		}

		if (right > 0) {
			dfs(result, s + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {

		GenerateParenthesesDFS gp = new GenerateParenthesesDFS();
		System.out.println(gp.generateParenthesis(3));
	}
}