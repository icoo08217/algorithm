package programmers.codingtest;

import java.util.*;

public class CodingTest2 {
    public static void main(String[] args) {
        Solution_CT2 solution = new Solution_CT2();
        int n = 5;
        int[][] quests = new int[][] {{1,3} , {1,4} , {3,5} , {5,4}} ;
        System.out.println(solution.solution(n , quests));

    }
}

class Solution_CT2 {
    public int[] solution(int n, int[][] quests) {

        int ans[] = new int[n];
        int cnt = 0;
        int[] preQuest = new int[n + 1];
        List<Integer>[] questInfo = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            questInfo[i] = new ArrayList<>();
        }

        for (int i = 0; i < quests.length; i++) {

            int a = quests[i][0];
            int b = quests[i][1];

            preQuest[b]++;
            questInfo[a].add(b);

        }
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (preQuest[i] == 0) {
                q.add(i);
            }

        }
        while (!q.isEmpty()) {
            int nowQuest = q.poll();
            ans[cnt++] = nowQuest;

            for (int i = 0; i < questInfo[nowQuest].size(); i++) {
                int next = questInfo[nowQuest].get(i);
                preQuest[next]--;
                if (preQuest[next] == 0) {
                    q.add(next);
                }
            }
        }
        return ans;
    }
}