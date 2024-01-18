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

        for(String s : str.split("\\s")){
            ary[i] = Integer.parseInt(s);
            i++;
        }

        int largest = ary[0];
        int prev_val = ary[0];

        for(i=1; i<N;i++){
           if(ary[i] < ary[i]+prev_val){
               prev_val = ary[i] + prev_val;
           }
           else prev_val = ary[i];
           if(largest<prev_val) largest = prev_val;
        }
        System.out.println(largest);
    }
}