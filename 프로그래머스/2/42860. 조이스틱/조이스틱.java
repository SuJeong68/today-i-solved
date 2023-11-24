class Solution {
    public int solution(String name) {
        int updown = 0;
        int length = name.length();
        int move = length - 1;
        
        for (int i = 0; i < length; i++) {
            updown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i * 2 + (length - next));
            move = Math.min(move, (length - next) * 2 + i);
        }
        return updown + move;
    }
}