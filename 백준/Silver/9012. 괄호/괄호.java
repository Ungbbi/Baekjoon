import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Stack{
    private int pivot;
    private final boolean[] value;

    public Stack(int N){
        value = new boolean[N];
        for(boolean v : value) v = false;
        pivot = 0;
    }
    public void push(){
        value[pivot] = true;
        pivot++;
    }
    public void pop(){
        pivot--;
        value[pivot] = false;
    }
    public boolean isEmpty(){
        return pivot == 0;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] str = new String[N];
        boolean isStop;

        for (int i = 0; i < N; i++) {
            isStop = false;
            str[i] = reader.readLine();
            char[] VPS = str[i].toCharArray();
            Stack stack = new Stack(VPS.length);
            for(char c :VPS){
                if(c=='(') {
                    stack.push();
                }
                else if(c==')') {
                    if(stack.isEmpty()) {
                        System.out.println("NO");
                        isStop = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if(isStop) continue;
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
        /*
        for(int i=0;i<N;i++){
            int index = 0; // ')'이 등장한 횟수

            // List는 '('이 등장하면 false 요소가 추가된다.
            List<Boolean> list = new ArrayList<>();
            str[i] = reader.readLine();
            char[] VPS = str[i].toCharArray();

            for(char c : VPS){
                if (c=='('){
                    list.add(false);
                }
                else if(c==')'){
                    // ')'가 가장 먼저 등장하면 VPS가 아니다. 또한 ')'의 등장 횟수가 '('가 등장한 횟수보다 많아지는 순간 VPS가 아니게 된다. 이를 위한 조건문이다.
                    if(index<list.size()) {
                        list.set(index, true);
                        index++;
                    }
                    else{
                        if(list.isEmpty()) list.add(false);
                        list.set(0,false);
                        break;
                    }
                }
            }
            boolean allTrue = true;
            // list의 요소가 모두 True라면 VPS이다.
            for(Boolean b: list){
                if(!b) {
                    allTrue = false;
                    break;
                }
            }
            if(allTrue) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
/*
===============추가 설명=================
a = boolean list 라 하자.  그리고 "(())("을 입력받아 한 문자씩 char 배열로 만들었다. '(','(',...,'('
for문으로 char배열 요소 하나씩 읽어들인다.
요소가 '(' 이면 a에 false 요소를추가시킨다. a[0] = false.
요소가 ')' 일 때, index가 List a의 크기보다 작다면. 리스트 a[index]의 값을 true로 변경한다. ( index는 ')'의 등장 횟수이다. )
   -  '('와 짝이 되야한다. a.size()는 '('의 등장 횟수인데 만약 index가 그보다 크다면 절대 VPS가 될 수 없기 때문이다.

모든 요소를 읽어들여 리스트를 완성시킨 후, 리스트의 모든 요소가 True인지 확인한다.
'('가 등장한 만큼 그에 대한 짝 ')'이 있다면 모든 요소는 True일 수 밖에 없다.
'('가 등장한 개수보다 ')'가 적게등장했다면 리스트의 요소 중 일부는 true로 바뀌지 않았기 때문이다.
*/