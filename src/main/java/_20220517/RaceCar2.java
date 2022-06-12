package _20220517;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar2 {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, 1});
        int moves = 0;
        Set<String> set = new HashSet();
        
        set.add(0 + " " + 1);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int[] current = q.poll();
                int speed = current[1];

                if(current[0] == target) return moves;
                
                int forward = current[0] + speed;       
                int forwardSpeed = speed*2;
                String key = (forward + " " + forwardSpeed);
                
                if(!set.contains(key) && forward > 0 && forward < target*2)
                {
                    q.offer(new int[]{forward, forwardSpeed});
                    set.add(key);
                }
                
                int reverse = current[0];
                int reverseSpeed = speed > 0 ? -1 : 1;
                key = (reverse + " " + reverseSpeed);
                
                if(!set.contains(key) && reverse > 0 && reverse < target*2)
                {
                    q.offer(new int[]{reverse, reverseSpeed});
                    set.add(key);
                }
            }
            moves++;
        }
        return moves;
    }
    
	public static void main(String[] args) {

		RaceCar2 rc = new RaceCar2();

		System.out.println(rc.racecar(7));

	}
}