package alimir;

public class MergeSortPractice {

	private void sort(int[] arr, int l, int r) {

		if (l < r) {
			int m = l + (r - l) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, r, m);

		}

	}

	private void merge(int[] arr, int l, int r, int m) {

		int l1 = m - l + 1;
		int l2 = r - m;

		int[] n1 = new int[l1];
		int[] n2 = new int[l2];

		for (int i = 0; i < l1; i++) {
			n1[i] = arr[l + i];

		}

		for (int i = 0; i < l2; i++) {
			n2[i] = arr[m + i + 1];

		}

		int i = 0, j = 0, k = l;
		while (i < l1 && j < l2) {

			if (n1[i] < n2[j]) {
				arr[k] = n1[i];
				i++;
				k++;
			} else {
				arr[k] = n2[j];
				j++;
				k++;
			}

		}

		while (i < l1) {
			arr[k] = n1[i];
			k++;
			i++;
		}

		while (j < l2) {
			arr[k] = n2[j];
			k++;
			j++;
		}

	}

	private void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();

	}

	public static void main(String[] args) {

		int[] array = { 67, 23, 19, 85, 62, 5, 2, 9 };

		MergeSortPractice msp = new MergeSortPractice();

		msp.printArray(array);

		msp.sort(array, 0, array.length - 1);

		msp.printArray(array);

	}

}