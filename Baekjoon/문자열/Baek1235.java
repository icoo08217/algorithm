package 문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1235 {
    public static void main(String[] args) throws IOException {

        // 풀이
        // 학생들의 번호를 뒤자리부터 검사한다. 만약 같은 숫자가 나타난다면 자리를 한자리 앞으로 앞당긴다.
        // 일 , 십 , 백 단위로 검사 ?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        // 학생 번호를 넣을 리스트
        List<String> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            // 학생 번호가 k개 들어온다.
            list.add(br.readLine());
        }

        int maxSize = String.valueOf(list.get(0)).length(); // 학생 번호의 최대 자리수

        for (int i = 0; i < maxSize; i++) {
            List<String> substringList = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                String temp = list.get(j);

                temp = temp.substring(maxSize - i - 1, maxSize);

                if (!substringList.contains(temp)){
                    substringList.add(temp);
                } else {
                    break;
                }
            }

            if (substringList.size() == k) {
                bw.write(i + 1 + "\n"); // 자릿수
                break;
            }
        }

        bw.flush();
        bw.close();

    }
}
