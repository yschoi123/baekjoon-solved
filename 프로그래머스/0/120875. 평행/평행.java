import java.util.*;

class Solution {
    public double slope(int x1, int y1, int x2, int y2) {
      return  (double)(y2 - y1) / (x2 - x1);
    }
    
    public boolean isEqualSlope(int[][] dots, int line1dot1, int line1dot2, int line2dot1, int lien2dot2) {
        double dydx1 = slope(dots[line1dot1][0], dots[line1dot1][1], dots[line1dot2][0], dots[line1dot2][1]);
        double dydx2 = slope(dots[line2dot1][0], dots[line2dot1][1], dots[lien2dot2][0], dots[lien2dot2][1]);
        
        return dydx1 == dydx2;
    }
        
    public int solution(int[][] dots) {
        List<Double> dydxList = new ArrayList<>();
        
        if(isEqualSlope(dots, 0, 1, 2, 3) || isEqualSlope(dots, 0, 2, 1, 3) || isEqualSlope(dots, 0, 3, 1, 2)) {
            return 1;
        }
        return 0;
    }
    
    
}