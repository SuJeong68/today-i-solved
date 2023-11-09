import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.word.equals(target)) {
                return current.count;
            }
            if (current.count >= words.length) {
                continue;
            }
            for (String word : words) {
                if (isOneDiffWord(current.word, word)) {
                    queue.offer(new Node(word, current.count + 1));
                }
            }
        }
        return 0;
    }

    private boolean isOneDiffWord(String current, String word) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != word.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}

class Node {
    String word;
    int count;

    Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}