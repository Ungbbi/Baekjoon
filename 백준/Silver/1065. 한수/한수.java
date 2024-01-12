import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String str;
        int cnt=0;
        for(int i=1;i<=N;i++){
            str = Integer.toString(i);
            char[] digit = str.toCharArray();
            int dl = digit.length;
            if(dl<3){
                cnt++;
            }
            else {
                int[] nums = new int[dl];
                for(int j=0;j<dl;j++){
                    nums[j] = digit[j]-'0';
                }
                int tmp = nums[1]-nums[0];
                boolean istrue = false;
                for(int j=1;j<dl-1;j++){
                    if(tmp == nums[j+1]-nums[j]){
                           istrue = true;
                    }
                    else istrue = false;
                }
                if (istrue) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
