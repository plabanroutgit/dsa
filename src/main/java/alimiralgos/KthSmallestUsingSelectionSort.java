package alimiralgos;

//Java program for implementation of Selection Sort
//https://www.geeksforgeeks.org/selection-sort/
public class KthSmallestUsingSelectionSort {

	int[] swap(int[] arr, int i, int min_idx) {
		// Swap the found minimum element with the first
		// element
		int temp = arr[min_idx];
		arr[min_idx] = arr[i];
		arr[i] = temp;

		return arr;
	}

	int sortandgetkth(int arr[], int k) {
		int n = arr.length;
		int kth_idx = 0;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < k; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			arr = swap(arr, i, min_idx);
			kth_idx = i;
		}
		return arr[kth_idx];
	}

	// Prints the array
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver code to test above
	public static void main(String args[]) {
		KthSmallestUsingSelectionSort ob = new KthSmallestUsingSelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		int k = 3;
		int kthsmallest = ob.sortandgetkth(arr, k);
		System.out.println("Sorted array " + kthsmallest);
		ob.printArray(arr);
	}
}

