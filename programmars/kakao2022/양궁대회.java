package programmers.kakao2022;

import java.util.Arrays;

public class 양궁대회 {
    public static void main(String[] args) {
        Solution_양궁대회 양궁대회 = new Solution_양궁대회();
        int n = 5;
        int[] info = new int[] {2,1,1,1,0,0,0,0,0,0,0};
        int[] ryan = 양궁대회.solution( n , info);
        for (int i = 0; i < ryan.length; i++) {
            System.out.print(ryan[i] + " ");
        }
    }
}

class Solution_양궁대회{
    public int[] solution(int n, int[] info) {

        int[] answer = new int[11]; // 정답을 저장할 배열
        int[] temp = new int[11]; // 정답이 저장되어 있는 배열과 비교할 배열
        int maxDiff = 0; // 라이언 총합과 어피치 총합의 차이를 저장할 변수

        for (int subset = 1; subset < (1 << 10); ++subset) {
            // 비트마스크 사용 (1 << 10) => 1024
            int ryan = 0 , appeach = 0 , count = 0; // 라이언 총합 , 어피치 총합 , 라이언이 사용한 화살의 갯수
            for (int i = 0; i < 10; ++i) {
                if ((subset & ( 1 << i)) != 0) { // 1 이라면 라이언이 승리
                    ryan += 10 - i;
                    temp[i] = info[i] + 1;
                    count += temp[i];
                } else { // 0 이라면 어피치가 승리 or 비김
                    temp[i] = 0; // 라이언은 화살을 하나도 사용하지 않음.
                    if (info[i] > 0) {
                        appeach += 10 - i;
                    }
                }
            }

            if ( count > n) continue; // 라이언이 화살을 n 개 보다 많이 사용했을 경우는 continue
            temp[10] = n - count; // 라이언의 남은 화살의 개수는 모두 0점 짜리 과녘을 맞췄다고 가정

            if (ryan - appeach == maxDiff) { // 여러가지 방법이 나올 경우
                for (int i = 10; i >= 0; i--) {
                    if (temp[i] > answer[i]) {
                        maxDiff = ryan - appeach;
                        answer = Arrays.copyOf(temp, temp.length);
                        break;
                    } else if (temp[i] < answer[i]) {
                        break;
                    }
                }
            } else if (ryan - appeach > maxDiff) { // 차이가 많이 나는 값으로 갱신.
                maxDiff = ryan - appeach;
                answer = Arrays.copyOf(temp, temp.length);
            }
        }

        if (maxDiff == 0) { // 라이언이 이길수 있는 경우가 없다면 -1 return
            return new int[]{-1};
        }

        return answer;
    }
}