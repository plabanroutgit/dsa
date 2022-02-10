package alimir;

//Java implementation of recursive Binary Search
public class BinarySearchIterative {
	// Returns index of x if it is present in arr[l..
	// r], else return -1
	int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while (left <= right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// End Condition: left > right
		return -1;
	}

	// Driver method to test above
	public static void main(String args[]) {
		BinarySearchIterative ob = new BinarySearchIterative();
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 10;
		int result = ob.binarySearch(arr, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);
	}
}
