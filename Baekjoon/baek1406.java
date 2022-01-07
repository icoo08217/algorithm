

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int M = Integer.parseInt(br.readLine());

        // 스택을 이용한 커서 구현
        Stack<Character> leftStk = new Stack<>();
        Stack<Character> rightStk = new Stack<>();

        // 첫 커서의 위치는 오른쪽 끝이기 때문에 왼쪽 스택에 모두 넣어준다.
        for (char c : input.toCharArray()) {
            leftStk.push(c);
        }

        // 명령어 M번 반복
        for (int i = 0; i<M; i++){
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c){
                case 'L':
                    if (!leftStk.isEmpty()) {
                        rightStk.push(leftStk.pop());
                    }
                    break;

                case 'D':
                    if (!rightStk.isEmpty()){
                        leftStk.push(rightStk.pop());
                    }
                    break;

                case 'B':
                    if (!leftStk.isEmpty()){
                        leftStk.pop();
                    }
                    break;

                case 'P':
                    char plus = command.charAt(2); // index는 2다 input의 값이 가운데에는 공백이 있기 떄문에 공백까지 계산해야함.
                    leftStk.push(plus);
                    break;
            }

        }

        while (!leftStk.isEmpty()){
            rightStk.push(leftStk.pop());
        }

        while (!rightStk.isEmpty()){
            sb.append(rightStk.pop());
        }

        System.out.println(sb);

    }
}