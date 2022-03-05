package alimir;

public class MyHashSet1Ops {

	public static void main(String[] args) {
		MyHashSet1 mhs1 = new MyHashSet1();
		
		mhs1.add(10);
		mhs1.add(44);
		mhs1.add(53);
		mhs1.add(95);
		
		System.out.println(mhs1.contains(53));
		
		mhs1.remove(53);
		
		System.out.println(mhs1.contains(53));
		
	}

}
