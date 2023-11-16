class Solution {
    public int solution(int a, int b) {
        return Math.max(2 * a * b, Integer.parseInt(a + "" + b));
    }
}