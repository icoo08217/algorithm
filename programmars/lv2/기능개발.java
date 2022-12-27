package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {
        Solution_기능개발 solution = new Solution_기능개발();

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        int[] answer = solution.solution(progresses, speeds);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}

class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        // 앞에 있는 작업부터 완료가 되어야한다.
        // progresses의 각 요소가 100이 되면 작업 종료가 된다.
        // 큐에 넣어서 작업도가 100이 넘어가는 것부터 앞에서 빼기 시작함.
        // 100이 넘지 않은 것은 빼지 않음.
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < speeds.length; i++) {
            q.offer((100 - progresses[i]) / speeds[i] +
                    ((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1) );
        }

        int count = 1;
        int now = q.poll();
        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty()) {
            int next = q.poll();
            if( now >= next) {
                count++;
            } else {
                list.add(count);
                count = 1;
                now = next;
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
