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

        int[] numbers = new int[N+1]; // N이하의 양의 정수 값 배열
        List<Character> calcul = new ArrayList<>(); // 연산 과정을 저장할 리스트

        for(int i=1;i<=N;i++){      // 정수 값 배열 생성
            numbers[i] = i;
        }

        Stack stack = new Stack(N);

        int j = 1; // 정수 값 배열에서 하나씩 가져오기 위한 인덱스.

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
        // 스택이 Empty라면 수열이 완성된 것
        if(stack.isEmpty()){
            for(char c : calcul){
                System.out.println(c);
            }
        }
        else System.out.println("NO");
    }
}
