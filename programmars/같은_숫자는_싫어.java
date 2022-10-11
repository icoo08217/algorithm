package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        Solution_HateSameNum solution = new Solution_HateSameNum();
        int[] arr = new int[]{1,1,3,3,0,1,1};
        for (int i : solution.solution(arr)) {
            System.out.println(i);
        }
    }

}

class Solution_HateSameNum {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList();

        Stack<Integer> stk = new Stack();
        for (int i : arr) {
            if (stk.empty()){
                stk.push(i);
            } else if (stk.peek() == i) {
                stk.push(i);
            } else { //stk.peek() != i
                answer.add(stk.pop());
                stk.clear();
                stk.push(i);
            }
        }

        answer.add(stk.pop());

        return answer;
    }
}
