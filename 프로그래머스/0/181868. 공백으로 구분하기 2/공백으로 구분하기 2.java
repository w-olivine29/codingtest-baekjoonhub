class Solution {
    public String[] solution(String my_string) {
        
        my_string = my_string.strip();
        String[] answer = my_string.split("\\s+");
        for(int i = 0; i < answer.length; i++){
            answer[i] = answer[i].strip();
        }
        
        return answer;
    }
}