class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String bad : babbling) {
            String temp = bad;
            for(String word : words) {
                temp = temp.replace(word, " ");
            }
            
            answer += ("".equals(temp.trim()) ? 1 : 0);
        }
    
        return answer;
    }
}