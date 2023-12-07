import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(solution(Integer.parseInt(br.readLine()))));
        bw.flush();
    }

    public static int solution(int n) {
        String front = "0";
        int changingNum = 0;

        int count = 1;
        while (true) {
            int temp, end;
            if (changingNum == 6) {
                if (front.endsWith("66")) {
                    temp = 0;
                    end = 1000;
                } else if (front.endsWith("6")) {
                    temp = 600;
                    end = 700;
                } else {
                    temp = 660;
                    end = 670;
                }
            } else {
                temp = 666;
                end = 667;
            }

            for (int i = temp; i < end; i++) {
                if (count++ == n) {
                    return Integer.parseInt(String.format("%s%d%03d", front, changingNum, i));
                }
            }
            changingNum++;
            if (changingNum == 10) {
                front = Integer.toString(Integer.parseInt(front) + 1);
                changingNum = 0;
            }
        }
    }
}
