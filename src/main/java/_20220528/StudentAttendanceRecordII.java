package _20220528;

//https://www.youtube.com/watch?v=D5g-KZWbh6Y
public class StudentAttendanceRecordII {

	int MOD = 10 ^ 9 + 7;

	public int checkRecord(int n) {

		return dfs(n, 0, false);

	}

	int dfs(int n, int consecutiveL, boolean hasA) {

		if (n == 0)
			return 1;

		int tmp = 0;

		if (!hasA) {
			tmp += dfs(n - 1, consecutiveL, true);
			tmp %= MOD;
		}

		if (consecutiveL < 2) {
			tmp += dfs(n - 1, consecutiveL + 1, hasA);
			tmp %= MOD;
		}

		tmp += dfs(n - 1, consecutiveL, hasA);
		tmp %= MOD;

		return tmp;
	}

	public static void main(String[] args) {

		StudentAttendanceRecordII s = new StudentAttendanceRecordII();
		System.out.println(s.checkRecord(3));

	}

}
