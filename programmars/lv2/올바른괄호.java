package programmers.lv2;

import java.util.Stack;

public class 올바른괄호 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(()("));
    }

    static class Solution{

        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stk = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ('(')) {
                    stk.push(s.charAt(i));
                } else {
                    if (!stk.isEmpty()) {
                        stk.pop();
                    } else {
                        answer = false;
                        break;
                    }
                }
            }

            if (!stk.isEmpty()) {
                answer = false;
            }

            return answer;
        }
    }
}
