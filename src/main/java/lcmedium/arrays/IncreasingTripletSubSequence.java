package lcmedium.arrays;

//https://www.youtube.com/watch?v=xZ5FBqk-cFw
//T:o(n) SC: o(1)
public class IncreasingTripletSubSequence {

	public static boolean increasingTriplet(int[] nums) {
		int f = Integer.MAX_VALUE;
		int s = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num <= f) {
				f = num;// update x to be a smaller value
			} else if (num <= s) {
				s = num; // update y to be a smaller value
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };

		System.out.println(increasingTriplet(a));

		int[] b = { 2, 1, 5, 0, 4, 6 };

		System.out.println(increasingTriplet(b));
	}
}
