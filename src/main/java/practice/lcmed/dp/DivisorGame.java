package practice.lcmed.dp;

//https://www.youtube.com/watch?v=MWiWNUzCR3Q
public class DivisorGame {

	public boolean divisorGame(int N) {
		return N % 2 == 0;
	}

	public static void main(String[] args) {

		DivisorGame cb = new DivisorGame();
		System.out.println(cb.divisorGame(5));

	}

}
