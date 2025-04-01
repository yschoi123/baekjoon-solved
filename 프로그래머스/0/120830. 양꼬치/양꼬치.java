class Solution {
    public int solution(int n, int k) {
        
        int sheep = 12000;
        int drink = 2000;

        int answer = sheep * n + 2000 *(k-n/10);
        return answer;
    }
}