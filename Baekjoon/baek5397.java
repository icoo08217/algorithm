import java.io.*;
import java.util.*;

// 스택 2개로 커서를 구현하였다. 스택1 과 스택2를 사이에 커서가 위치해있다고 생각하면 된다.
class baek5397{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i<T; i++) {
            Stack<Character> stk1 = new Stack<>();
            Stack<Character> stk2 = new Stack<>();
            StringBuilder sb = new StringBuilder();

            String s = br.readLine();

            for (Character c: s.toCharArray()){
                if (c =='<') {
                    if (stk1.isEmpty()) continue;
                    stk2.push(stk1.pop());
                }
                else if (c == '>') {
                    if (stk2.isEmpty()) continue;
                    stk1.push(stk2.pop());
                }
                else if (c== '-') {
                    if (stk1.isEmpty()) continue;
                    stk1.pop();
                }
                else stk1.push(c);
            }

            while (!stk2.isEmpty()){
                stk1.push(stk2.pop());
            }

            while (!stk1.isEmpty()){
                sb.append(stk1.pop());
            }

            System.out.println(sb.reverse());
        }
    }
}