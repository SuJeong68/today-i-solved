import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.contains("push")) {
                stack.push(input.substring(5));
            } else {
                switch (input) {
                    case "top":
                        bw.write(stack.empty() ? "-1" : stack.peek());
                        break;
                    case "size":
                        bw.write(Integer.toString(stack.size()));
                        break;
                    case "empty":
                        bw.write(stack.empty() ? "1" : "0");
                        break;
                    case "pop":
                        bw.write(stack.empty() ? "-1" : stack.pop());
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
