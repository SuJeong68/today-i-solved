import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                if (isNo(input, i, stack)) {
                    break;
                }
            }
        }
    }

    private static boolean isNo(String input, int i, Stack<Character> stack) {
        char ch = input.charAt(i);
        switch (ch) {
            case '(':
            case '[':
                stack.push(ch);
                break;
            case ')':
                if (stack.empty() || stack.pop() != '(') {
                    System.out.println("no");
                    return true;
                }
                break;
            case ']':
                if (stack.empty() || stack.pop() != '[') {
                    System.out.println("no");
                    return true;
                }
                break;
            case '.':
                if (!stack.empty()) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
        }
        return false;
    }
}
