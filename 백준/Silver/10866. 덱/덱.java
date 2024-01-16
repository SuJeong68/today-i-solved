import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.contains("push_front")) {
                deque.addFirst(input.substring(11));
            } else if (input.contains("push_back")) {
                deque.addLast(input.substring(10));
            }else {
                String s = "";
                switch (input) {
                    case "pop_front":
                        s = deque.isEmpty() ? "-1" : deque.pollFirst();
                        break;
                    case "pop_back":
                        s = deque.isEmpty() ? "-1" : deque.pollLast();
                        break;
                    case "size":
                        s = String.valueOf(deque.size());
                        break;
                    case "empty":
                        s = deque.isEmpty() ? "1" : "0";
                        break;
                    case "front":
                        s = deque.isEmpty() ? "-1" : deque.peekFirst();
                        break;
                    case "back":
                        s = deque.isEmpty() ? "-1" : deque.peekLast();
                        break;
                }
                bw.write(s);
                bw.newLine();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
