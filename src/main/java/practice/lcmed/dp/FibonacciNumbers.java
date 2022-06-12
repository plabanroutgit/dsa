package practice.lcmed.dp;

public class FibonacciNumbers {

	public int fib(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);

	}

	public static void main(String[] args) {

		FibonacciNumbers cb = new FibonacciNumbers();
		System.out.println(cb.fib(5));

	}

}
