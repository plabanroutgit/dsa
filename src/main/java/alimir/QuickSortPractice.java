package alimir;

public class QuickSortPractice {

	public static void main(String[] args) {

		int[] array = { 53, 674, 737, 93, 263, 9465, 23, 45, 500 };

		printArray(array);

		sort(array, 0, array.length - 1);

		printArray(array);
	}

	private static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}

	private static void sort(int[] arr, int l, int h) {
		if (l < h) {
			int p = partition(arr, l, h);

			sort(arr, l, p - 1);
			sort(arr, p + 1, h);
		}
	}

	private static int partition(int[] arr, int l, int h) {

		int i = l - 1;
		int pivot = arr[h];

		for (int j = l; j <= h - 1; j++) {
			if (arr[j] < pivot) {
				++i;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, h);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}