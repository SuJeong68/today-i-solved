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

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] splited = br.readLine().split("");

            if (isVPS(splited)) {
                bw.write("YES") ;
            } else {
                bw.write("NO");
            }
            bw.newLine();
        }
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean isVPS(String[] splited) {
        Stack<String> stack = new Stack<>();
        for (String s : splited) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.empty() || !stack.pop().equals("(")) {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
