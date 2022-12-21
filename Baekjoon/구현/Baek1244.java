package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class Baek1244 {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 여자 --> 조건 : 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서
        // 가장 많은 스위치를 포함하는 구간을 찾아서 그 구간에 속하는 스위치의 상태를 모두 바꾼다.

        int n = Integer.parseInt(br.readLine()); // switch 개수
        int[] switchArr = new int[n]; // 스위치의 상태를 저장할 배열

        String status = br.readLine();

        for (int i = 0; i < n; i++) {
            switchArr[i] = Integer.parseInt(status.split(" ")[i]);
        }

        int studentNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남자 , 조건 1. 스위치 번호가 자기가 받은 수의 배수이면, 스위치의 상태를 바꿈.
                for (int j = 0; j < n; j++) {
                    if( (j+1) % switchNum == 0) {
                        switchArr[j] = switchArr[j] == 0 ? 1 : 0 ;
                    }
                }
            } else { // 여자 조건 : 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서
                // 가장 많은 스위치를 포함하는 구간을 찾아서 그 구간에 속하는 스위치의 상태를 모두 바꾼다.
                switchArr[switchNum-1] = switchArr[switchNum-1] == 0 ? 1 : 0;
                for (int j = 1; j < n / 2; j++) {
                    if(switchNum-1-j < 0 || switchNum-1 + j >= n) break;
                    if(switchArr[switchNum-1-j] == switchArr[switchNum-1 + j]) {
                        switchArr[switchNum-1 - j] = switchArr[switchNum-1 - j] == 0 ? 1 : 0;
                        switchArr[switchNum-1 + j] = switchArr[switchNum-1 + j] == 0 ? 1 : 0;
                    }
                    else break;
                }
            }
        }

        // 한 줄에 20개의 스위치씩 출력
        for (int i = 0; i < n; i++) {
            bw.write(switchArr[i] + " ");
            if ((i+1) % 20 == 0 ) {
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();

    }
}

