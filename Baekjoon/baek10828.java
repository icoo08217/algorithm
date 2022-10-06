
import java.io.*;
import java.util.*;

class baek10828{

    static Stack<Integer> stk = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N은 명령의 수

        StringTokenizer st;
        String[] str = new String[2];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            str[0] = st.nextToken();
            if(st.hasMoreTokens()) {
                str[1] = st.nextToken();
            }

            if(str[0].equals("push")){
                push(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop")) {
                if (stk.size() == 0){
                    result.add(-1);
                } else {
                    result.add(pop());
                }
            } else if(str[0].equals("size")) {
                result.add(size());
            } else if(str[0].equals("empty")) {
                result.add(empty());
            } else if(str[0].equals("top")) {
                result.add(top());
            }
        }

        for (Integer i : result) {
            System.out.println(i);
        }
    }

    static void push(int x){
        stk.push(x);
    }

    static int pop(){
        return stk.pop();
    }

    static int size(){
        return stk.size();
    }

    static int empty(){
        if (stk.empty()){
            return 1;
        } else
            return 0;
    }

    static int top(){
        if (stk.empty()){
            return -1;
        } else return stk.peek();
    }
}
