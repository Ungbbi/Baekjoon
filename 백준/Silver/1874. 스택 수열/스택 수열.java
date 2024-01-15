import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Stack{
    private int pivot;
    private final int[] value;

    public Stack(int N){
        value = new int[N];
        pivot = 0;
    }
    public void push(int n){
        value[pivot] = n;
        pivot++;
    }
    public void pop(){
        pivot--;
        value[pivot] = 0;
    }
    public boolean isEmpty(){
        return pivot == 0;
    }

    public int top(){
        if(this.isEmpty()) return 0;
        return value[pivot-1];
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] numbers = new int[N+1];
        int[] answer = new int[N];
        List<Character> calcul = new ArrayList<>();

        for(int i=1;i<=N;i++){
            numbers[i] = i;
        }
        Stack stack = new Stack(N);
        int j = 1;

        for(int i=0;i<N;i++){
            int n  = Integer.parseInt(reader.readLine());
            while(stack.top()!=n){
                if(j>N) break; // 더 이상 push할 값이 없음.
                stack.push(numbers[j]);
                calcul.add('+');
                j++;
            }
            if(stack.top()==n){
                stack.pop();
                calcul.add('-');
            }
        }
        if(stack.isEmpty()){
            for(char c : calcul){
                System.out.println(c);
            }
        }
        else System.out.println("NO");
    }
}