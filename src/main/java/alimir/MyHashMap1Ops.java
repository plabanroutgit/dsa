package alimir;

public class MyHashMap1Ops {
	public static void main(String[] args) {
		MyHashMap1 mhm1 = new MyHashMap1();
		
		mhm1.add(10, 75);
		mhm1.add(20, 7766);
		mhm1.add(30, 79875);
		
		System.out.println(mhm1.get(10));
		System.out.println(mhm1.get(20));
		System.out.println(mhm1.get(0));
		
		mhm1.remove(20);
		
		System.out.println(mhm1.get(20));
		
	}
}
