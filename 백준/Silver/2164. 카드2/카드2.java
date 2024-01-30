import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/*
1. FIFO이므로 큐를 사용, 2-2에 의해 큐의 사이즈가 늘어나게 되므로 원형큐를 사용
2. 한 번의 작업에 두 가지의 행동을 순서대로 실행
    1) 맨 위에 있는 값은 버린다.
    2) 맨 위에 있는 카드를 맨 아래로 이동시킨다.
3. 카드가 한 장이 남게되면 종료.
* 자바에는 이미 스택, 큐가 클래스로 만들어져있으나 사용하지 않았다.
*/

public class Main {
    public static class Queue{
        int[] queue;
        int front;
        int rear;

        public Queue(int N) {
            this.queue = new int[N+1];
            this.front = 0;
            this.rear = 0;
        }

        public void enqueue(int n){
            if(isFull()) return;
            rear = (rear+1)%queue.length;
            queue[rear] = n;
        }
        
        // 문제에서의 2-1을 discard 로 구현
        public void discard(){
            if(isEmpty()) return ;
            front = (front+1)%queue.length;
            queue[front] = 0 ;
        }
        
        public int dequeue(){
            if(isEmpty()) return 0;
            front = (front+1)%queue.length;
            int result = queue[front];
            queue[front] = 0;

            return result;
        }
        public boolean isFull(){
            return (rear+1)%queue.length==front;
        }
        public boolean isEmpty(){
            return front==rear;
        }
        public boolean leftOne(){
            return (front+1)%queue.length == rear;
        }
        // 2를 실행
        public void moveBottom(){
            int tmp;
            this.discard();
            tmp = this.dequeue();
            this.enqueue(tmp);
        }
        
        public int task(){

            for(int i=1;i<queue.length;i++){
                this.enqueue(i);
            }
            while(!leftOne()){
                moveBottom();
            }
            return queue[rear];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Queue queue = new Queue(N);

        System.out.println(queue.task());
    }
}