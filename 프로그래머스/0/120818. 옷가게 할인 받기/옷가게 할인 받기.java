class Solution {
    public int solution(int price) {

        int sale = 0;
        if(price >= 500000) {
            sale = 20;
        } else if(price >= 300000) {
            sale = 10;
        } else if(price >= 100000) {
            sale = 5;
        }
        
        return (int)(price * ((100-sale)/(double)100));
    }
}