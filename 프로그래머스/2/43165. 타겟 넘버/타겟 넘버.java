class Solution {
    static int n, answer;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        bfs(numbers, 0, target, 0);
        return answer;
    }
    
    static public void bfs(int[] numbers,int x, int target, int cal){
        if(x == n) {
            if(cal == target) answer++;
            return;
        }
        
        bfs(numbers, x+1, target, cal + numbers[x]);
        bfs(numbers, x+1, target, cal - numbers[x]);
    }
}