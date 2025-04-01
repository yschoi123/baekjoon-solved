class Solution {
    public int solution(int n) {
        int sliceCnt = 7;
        
        int answer = n/sliceCnt + ((n % sliceCnt != 0) ? 1 : 0);
        return answer;
    }
}