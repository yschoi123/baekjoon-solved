import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        List<Double> dydxList = new ArrayList<>();
        
        double dydx1 = (double)(dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]);
        double dydx2 = (double)(dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]);
        if(dydx1 == dydx2) {
            return 1;
        }
        
        dydx1 = (double)(dots[2][1] - dots[0][1]) / (dots[2][0] - dots[0][0]);
        dydx2 = (double)(dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0]);
        if(dydx1 == dydx2) {
            return 1;
        }
        
        dydx1 = (double)(dots[3][1] - dots[0][1]) / (dots[3][0] - dots[0][0]);
        dydx2 = (double)(dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0]);
        if(dydx1 == dydx2) {
            return 1;
        }
        
        dydx1 = (double)(dots[3][1] - dots[0][1]) / (dots[3][0] - dots[0][0]);
        dydx2 = (double)(dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0]);
        if(dydx1 == dydx2) {
            return 1;
        }
        return 0;
    }
}