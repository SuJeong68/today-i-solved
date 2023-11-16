class Solution {
    public int solution(int a, int b) {
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        
        return Math.max(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));
    }
}