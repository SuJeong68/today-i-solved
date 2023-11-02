class Solution {
    public int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }

    public int DFS(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }     
        
        return DFS(numbers, target, sum + numbers[index], index + 1) 
            + DFS(numbers, target, sum - numbers[index], index + 1);
    }
}