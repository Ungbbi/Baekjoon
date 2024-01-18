import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        int[]ary = new int[N];
        int[]dp = new int[N];

        int i = 0;
        int largest = 1;

        for(String s : str.split("\\s")){
            ary[i] = Integer.parseInt(s);
            i++;
        }
        dp[0] = 1;
        for(i=1; i<N;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(ary[j]<ary[i]){
                    if(dp[j]>=dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
            if (dp[i]>largest) largest=dp[i];
        }
        System.out.println(largest);
    }
}