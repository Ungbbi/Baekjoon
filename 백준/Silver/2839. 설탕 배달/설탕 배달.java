import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 5kg, 3kg 봉지
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int cnt = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                System.out.println(cnt);
                return;
            }
            else if (N < 3) {
                System.out.println("-1");
                return;
            }
            else {
                N -= 3;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}