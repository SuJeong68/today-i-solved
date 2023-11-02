class Solution {
    int count;

    public int solution(int[] numbers, int target) {
        count = 0;

        DFS(numbers, numbers[0], target, 1);
        DFS(numbers, -numbers[0], target, 1);

        return count;
    }

    public void DFS(int[] numbers, int sum, int target, int index) {
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
        } else {
            DFS(numbers, sum + numbers[index], target, index + 1);
            DFS(numbers, sum - numbers[index], target, index + 1);
        }
    }
}