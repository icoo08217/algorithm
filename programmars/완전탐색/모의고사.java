package programmers.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
        Solution_모의고사 solution = new Solution_모의고사();

        int[] answers = new int[]{1,2,3,4,5};
        int[] test = solution.solution(answers);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int testCase : test) {
            sb.append(testCase).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");

        System.out.println(sb);
    }
}

class Solution_모의고사 {
    public int[] solution(int[] answers) {

        // 1번 수포자 1,2,3,4,5 ....
        // 2번 수포자 2,1,2,3,2,4,2,5 ....
        // 3번 수포자 3,3,1,1,2,2,4,4,5,5 .....
        int[] supoja1 = new int[]{1, 2, 3, 4, 5};
        int[] supoja2 = new int[]{2,1,2,3,2,4,2,5};
        int[] supoja3 = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supoja1[i%5]) {
                count[0]++;
            }

            if (answers[i] == supoja2[i%8]) {
                count[1]++;
            }

            if (answers[i] == supoja3[i%10]) {
                count[2]++;
            }
        }

        int max = Math.max(count[0] , Math.max(count[1] , count[2]));
        List<Integer> list = new ArrayList<>();

        if (count[0] == max) list.add(1);
        if (count[1] == max) list.add(2);
        if (count[2] == max) list.add(3);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
