package _20220609;

//https://www.youtube.com/watch?v=q6IEA26hvXc
public class MedianOfTwoSortedArrays4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findMedianSortedArrays(nums2, nums1);

		int m = nums1.length;
		int n = nums2.length;
		int start = 0;
		int end = m;
		while (start <= end) {
			int xpart = (start + end) / 2;
			int ypart = (m + n + 1) / 2 - xpart;

			int left_x = (xpart == 0) ? Integer.MIN_VALUE : nums1[xpart - 1];
			int right_x = (xpart == m) ? Integer.MAX_VALUE : nums1[xpart];

			int left_y = (ypart == 0) ? Integer.MIN_VALUE : nums2[ypart - 1];
			int right_y = (ypart == n) ? Integer.MAX_VALUE : nums2[ypart];

			if (left_x <= right_y && left_y <= right_x) {
				if ((m + n) % 2 == 0) {
					return (double) (Math.max(left_x, left_y) + Math.min(right_x, right_y)) / 2;
				} else {
					return (double) Math.max(left_x, left_y);
				}
			} else if (left_x > right_y) {
				end = xpart - 1;
			} else {
				start = xpart + 1;
			}
		}
		return -1.00;
	}

	public static void main(String[] args) {

		// int[] nums1 = { 1, 2, 3, 4, 5 }, nums2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] nums1 = { 1, 3 }, nums2 = { 2 };

		MedianOfTwoSortedArrays4 med = new MedianOfTwoSortedArrays4();

		System.out.println(med.findMedianSortedArrays(nums1, nums2));
	}

}
