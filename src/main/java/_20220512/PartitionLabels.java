package _20220512;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {

	public List<Integer> partitionLabels(String s) {

		char[] c = s.toCharArray();

		List<Integer> l = new LinkedList<Integer>();

		int lidx = 0;
		int i = 0, j = 0;
		while (i < s.length()) {

			lidx = s.lastIndexOf(s.charAt(i));
			j = i;
			while (j <= lidx) {
				if (s.lastIndexOf(s.charAt(j)) > lidx)
					lidx = s.lastIndexOf(s.charAt(j));
				j++;

			}
			l.add(lidx - i + 1);
			i = j;

		}

		return l;
	}

	public static void main(String[] args) {

		String s = "eccbbbbdec";

		PartitionLabels pl = new PartitionLabels();

		System.out.println(pl.partitionLabels(s));

	}

}
