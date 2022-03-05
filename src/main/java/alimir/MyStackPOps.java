package alimir;

public class MyStackPOps {

	public static void main(String[] args) {
		MyStackP<Integer> s = new MyStackP<Integer>();

		s.push(3);
		s.push(66);
		s.push(55);
		s.push(33);
		s.push(55);
		s.push(359);
		s.push(35);
		s.push(328);
		s.push(7685);
		s.push(64);
		s.push(221);
		s.push(3458);
		s.push(7754);
		s.push(555);
		s.push(97);
		s.push(122);
		s.push(44);

		System.out.println(s.toString());
		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		
		System.out.println(s.toString());
	}

}
