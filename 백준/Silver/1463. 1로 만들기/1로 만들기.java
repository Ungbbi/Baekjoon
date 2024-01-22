import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        // 배열 dp는 각 인덱스가 1로 만들어지기까지의 연산 횟수에 대한 값이 저장된 배열이다.
        int[] dp = new int[N+1];
        
        for (int n =2;n<=N;n++){
            dp[n] = N;
        }
        
        // 1은 연산횟수가 0이다.
        dp[1] = 0;
        for(int i = 2 ;i<=N;i++){
            int min ;
            int val;
            // 2로 나누어 진다면
            if(i%2==0){
                min = i/2;
                dp[i] = dp[min]+1;
            }
            if(i%3==0){
                min = i/3;
                if(dp[i]>dp[min]+1) dp[i] = dp[min]+1;
            }
            min = i-1;
            if(dp[i]>dp[min]+1) dp[i] = dp[min]+1;
        }
        System.out.println(dp[N]);
    }
}