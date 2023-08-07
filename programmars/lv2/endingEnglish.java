package programmers.lv2;

import java.util.*;

public class endingEnglish {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int n = 3;
//        int n = 5;
        int n = 2;
//        String[] words = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//        String[] words = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution.solution(n, words)));
    }

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {};
            int cnt = 1;
            Set<String> set = new HashSet<>();
            set.add(words[0]);

            for (int i = 1; i < words.length; i++) {
                if (set.contains(words[i])) break;
                if (words[i].charAt(0) == words[i - 1].charAt(words[i - 1].length() - 1)) {
                    set.add(words[i]);
                    cnt++;
                } else break;
            }

            if (cnt == words.length) answer = new int[]{0, 0};
            else answer = new int[] {cnt % n + 1 , cnt / n + 1};

            return answer;
        }
    }
}
