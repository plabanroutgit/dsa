package alimiralgos;

//Java program to print all
//permutations of a given string.
public class PermutationsUsingBackTracking {
	public static void main(String[] args) {
		String str = "ABCD";
		int n = str.length();
		PermutationsUsingBackTracking permutation = new PermutationsUsingBackTracking();
		permutation.permute(str, 0, n - 1);
	}

	/*
	 * Permutation function @param str string to calculate permutation for @param l
	 * starting index
	 * 
	 * @param r end index
	 */
	private void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				//str = swap(str, l, i); Not sure why this line??
			}
			System.out.println();
		}
	}

	/*
	 * Swap Characters at position
	 * 
	 * @param a string value @param i position 1 @param j position 2
	 * 
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		//System.out.println(i + " "+ j);
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}

