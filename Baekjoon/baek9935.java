
import java.io.*;
import java.util.*;

class baek9935{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();

        for (int i=0; i<input.length(); i++){ // stk1에 input 문자열 push
            stk1.push(input.charAt(i));
        }

        int index = 0;

        while (!stk1.isEmpty()){
            stk2.push(stk1.pop());
            if(stk2.peek() == bomb.charAt(bomb.length() - (index + 1))){
                index++;
            }
            else {
                index = 0;
                if (stk2.peek() == bomb.charAt(bomb.length() - (index + 1))){
                    index++;
                }
            }
            // index == 폭발 문자열의 길이가 같으면 제거해야함.
            if (index == bomb.length()){
                for(int j=0; j<bomb.length(); j++){
                    stk2.pop();
                }
                // 중복된 문자열을 다시 탐색하기 위하여 stk2에 있는 bomb.length() 만큼 stk1에 다시 push한다.
                for(int j=0; j<bomb.length(); j++){
                    if (!stk2.isEmpty()){
                        stk1.push(stk2.pop());
                    }
                    else { // 만약 stk2에 있는 원소를 모두 stk1에 옮겼거나 stk2가 비어있다면 for문 종료.
                        break;
                    }
                }
                index =0;
            }
        }
        if (stk2.isEmpty()){ //폭발문자열에의해 stk2가 비어있다면
            System.out.println("FRULA");
        }
        else{
            while (!stk2.isEmpty()){
                sb.append(stk2.pop());
            }
        System.out.println(sb);
        }
    }
}
