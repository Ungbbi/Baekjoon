import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack {
    private final int[] ary;
    private int p;

    public Stack(int size){
        ary = new int[size];
        p = 0;
    }
    public void push(int input){
        this.ary[p] = input;
        p++;
    }
    public void pop(){
        if(p==0){
            System.out.println("-1");
        }
        else {
            p--;
            System.out.println(ary[p]);
            ary[p] = 0;
        }
    }
    public void size(){
        System.out.println(p);
    }
    public void empty(){
        if(p==0) System.out.println("1");
        else System.out.println("0");
    }
    public void top(){
        if(p==0) System.out.println("-1");
        else{
            System.out.println(ary[p-1]);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Stack stack = new Stack(N);
        
        for(int i =0; i<N ; i++){
            String str = reader.readLine();
            String[] strAry = str.split("\\s");
            switch(strAry[0]){
                case "push":
                    int input = Integer.parseInt(strAry[1]);
                    stack.push(input);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    stack.top();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                default:
            }
        }
    }
}

