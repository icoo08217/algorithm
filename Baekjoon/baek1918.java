
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 연산자만 스택에 push
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();

        for (Character c : s.toCharArray()){

            // 1. 피연산자(문자)가 들어오면 그대로 출력
            if (c >= 'A' && c <='Z'){
                sb.append(c);
            }
            // 2. 여는 괄호 ( 가 나오면 스택에 그대로 push
            else if ( c == '(') {
                stack.push(c);
            }
            // 3. 닫는 괄호 ) 가 나오면
            // stack의 top이 여는괄호가 나오기 전까지 pop하여 문자열에 추가하기
            else if (c == ')'){
                while (!stack.isEmpty()) {
                    if (stack.peek() == '('){
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());

                }
            }

            // 4. 연산자가 나오면
            // 우선순위를 가려서 출력하기
            else {
                while ( !stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    // 우선순위를 판단할 메소드
    static int priority(char c){
        if (c =='('){
            return 0;
        } else if (c == '+' || c == '-'){
            return 1;
        } else
            return 2;
    }
}