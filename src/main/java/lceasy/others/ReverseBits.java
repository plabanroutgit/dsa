package lceasy.others;

public class ReverseBits {
	
	public static int reverseBits(int n) {
		int ans = 0;
		System.out.println(String.format("%32s", Integer.toBinaryString(n)).replaceAll(" ", "0"));
		for (int i = 0; i < 32; i++) {
			ans <<= 1;
			ans = ans | (n & 1);
			n >>= 1;
			System.out.println(String.format("%32s", Integer.toBinaryString(ans)).replaceAll(" ", "0"));
		}
		return ans;
	}

	public static void main(String[] args) {

		System.out.println(reverseBits(43261596));

	}

}



/*

n = 00000010100101000001111010011100

00000010100101000001111010011100

ans <<= 1;
00000000000000000000000000000000

(n & 1)
00000010100101000001111010011100
00000000000000000000000000000001
-----------------------------------
00000000000000000000000000000000

ans = ans | (n & 1);
00000000000000000000000000000000
00000000000000000000000000000000
----------------------------------
00000000000000000000000000000000


 */