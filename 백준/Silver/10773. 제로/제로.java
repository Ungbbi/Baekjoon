import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 문제 태그가 자료구조라서 스택을 사용

public class Main {
    public static class Stack{
        int[] value;
        int pivot;

        public Stack(int N) {
            this.value = new int[N];
            this.pivot = 0;
        }

        public void push(int n){
            if(!isFull()) {
                value[pivot] = n;
                pivot++;
            }
        }
        public void pop(){
            if(!isEmpty()){
                pivot--;
                value[pivot] = 0;
            }
        }
        public boolean isFull(){
            return pivot==value.length+1;
        }
        public boolean isEmpty(){
            if(pivot<=0) {
                pivot = 0;
                return true;
            }else return false;
        }

        public int sumStack(){
            int sum = 0;
            for(int i : this.value){
                sum += i;
            }
            return sum;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Stack stack = new Stack(N);

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(reader.readLine());
            
            if(num==0) stack.pop();
            else stack.push(num);
        }
        
        System.out.println(stack.sumStack());
    }
}