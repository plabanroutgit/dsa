package _20220523;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;


class DetectSquares2 {
    public Map<Pair<Integer, Integer>, Integer> map; // points
    
    public DetectSquares2() {
        map = new HashMap<>();
    }
    public void add(int[] point) {
        Pair<Integer, Integer> p = new Pair(point[0], point[1]);
        Integer c = map.get(p);
        if (c != null) {
            map.put(p, c + 1);
        } else {
            map.put(p, 1);
        }
    }
    
    public int count(int[] point) {
        if (map.size() < 3) {
            return 0;
        }
        int res = 0; // count

        int x = point[0];
        int y = point[1];
        
        Pair<Integer, Integer> p = new Pair(x, y);
        
        for (Pair<Integer, Integer> p1 : map.keySet()) {
            // find first point, y1 = yp, but x1 != xp
            if (p1.getKey() != x && p1.getValue() == y) {
                int c1 = map.get(p1);
                int x1 = p1.getKey();
                int y1 = p1.getValue();
                
                // find 2nd point, Math.abs(y2 - y1) = Math.abs(x1 - xp), x2 == x1
                // find 3rd point, x3 = x, y3 = y2
                
                Pair<Integer, Integer> p2 = new Pair(x1, y1 + Math.abs(x1 - x));
                Pair<Integer, Integer> p3 = new Pair(x, y1 + Math.abs(x1 - x));
                
                if (map.containsKey(p2) && map.containsKey(p3)) {
                    res += c1 * map.get(p2) * map.get(p3);
                }
                
                p2 = new Pair(x1, y1 - Math.abs(x1 - x));
                p3 = new Pair(x, y1 - Math.abs(x1 - x));
                
                if (map.containsKey(p2) && map.containsKey(p3)) {
                    res += c1 * map.get(p2) * map.get(p3);
                }
            }
        }
        return res;     
    }
}