import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int binarySearch(int[] ary, int key,int first, int last){
        if (first>last){
            return 0;
        }

        int mid = (last+first)/2;
        if (first==last){
            if(ary[first]==key) return 1;
            else return 0;
        }

        if (ary[first] == key || ary[last] == key) return 1;

        if(ary[mid]>key){
            last = mid-1;
            return binarySearch(ary,key,first,last);
        }
        if(ary[mid]<key){
            first = mid+1;
            return binarySearch(ary,key,first,last);
        }
        if(ary[mid]==key){
            return 1;
        }
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        String strN = reader.readLine();
        String[] strAryN = strN.split("\\s");
        for(int i=0; i<strAryN.length;i++){
            A[i] = Integer.parseInt(strAryN[i]);
        }
        int M = Integer.parseInt(reader.readLine());
        int[] B = new int[M];
        String strM = reader.readLine();
        String[] strAryM = strM.split("\\s");
        for(int i=0; i<strAryM.length;i++){
            B[i] = Integer.parseInt(strAryM[i]);
        }

        int first = 0;
        int last = A.length-1;
        Arrays.sort(A);
        for (int i : B) {
            if (binarySearch(A, i, first, last) == 1) {
                System.out.println("1");
            } else System.out.println("0");
        }
    }
}

