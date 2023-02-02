package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 약수의_합 {
    public static void main(String[] args) {
        Solution_약수의_합 solution = new Solution_약수의_합();
        System.out.println(solution.solution(12));
        System.out.println(solution.solution(5));
    }
}

class Solution_약수의_합 {
    public int solution(int n) {
        // 정수n을 입력 받고
        // 정수 n 까지의 숫자를 하나씩 검사하면서 나머지가 0 인 값을 list에 추가하여
        // list의 요소들을 모두 더한 값을 answer에 저장
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if ( n % i == 0) {
                list.add(i);
            }
        }
        int answer = 0;

        for (Integer number : list) {
            answer += number;
        }

        return answer;
    }
}
