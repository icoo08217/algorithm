
import java.util.*;
import java.io.*;

class baek17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        boolean tagFlag = false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
                if (c == '<') {
                    if (!stack.isEmpty()) {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                    }
                    tagFlag = true; // 태그가 시작되면 tagFlag를 true 값으로 지정.
                    sb.append('<'); // < tag가 시작되면 그 안의 알파벳들은 모두 무시한다.
                }
                 else if (c == '>') {
                    tagFlag = false; // 태그가 끝나면 tagFlag를 false 값으로 지정해서 태그가 끝났음을 알린다.
                    sb.append('>');
                } else if (c == ' ') {
                    if (tagFlag == false) {
                        while (!stack.isEmpty()){
                            sb.append(stack.pop());
                        }
                        sb.append(' ');
                    } else {
                        sb.append(c);
                    }
                } else if (tagFlag == false){ // tageFlag가 false 이면 스택에 push.
                    stack.push(c);
                } else { // tagFlag가 true이면 그냥 출력
                    sb.append(c);
                }
        }

        if (!stack.isEmpty()){
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }
        System.out.println(sb);
    }
}


