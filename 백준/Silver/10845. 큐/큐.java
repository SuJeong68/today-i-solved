import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<String> queue = new LinkedList<>();

        String tmp = "-1";
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.contains("push")) {
                tmp = input.substring(5);
                queue.add(input.substring(5));
            } else {
                switch (input) {
                    case "front":
                        bw.write(queue.isEmpty() ? "-1" : queue.peek());
                        break;
                    case "back":
                        bw.write(queue.isEmpty() ? "-1" : tmp);
                        break;
                    case "size":
                        bw.write(Integer.toString(queue.size()));
                        break;
                    case "empty":
                        bw.write(queue.isEmpty() ? "1" : "0");
                        break;
                    case "pop":
                        bw.write(queue.isEmpty() ? "-1" : queue.poll());
                        break;
                }
                bw.newLine();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
