import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            String input = br.readLine();
            if (input.equals("0")) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += Integer.parseInt(stack.pop());
        }
        System.out.print(sum);

        br.close();
    }
}
