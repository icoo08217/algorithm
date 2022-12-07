package 문자열;


import java.io.*;

// 단어 나누기
public class Baek1251_Fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();

        int compare1 = 123; // z => 122 값 이므로 이보다 작은 수가 나오면 변경해야할 변수
        int firstStandard = 0;
        // 97 ~ 122
        // 들어온 word에서 사전 제일 맨 앞에 나오는 단어 찾기
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < compare1) {
                compare1 = c;
                firstStandard = i;
            }
        }

        // 첫번째 기준점이 되는 문자 뒤 자르기
        String firstWord = word.substring(0,firstStandard+1);
        String nextWord = word.substring(firstStandard+1,word.length());

        int compare2 = 123;
        int secondStandard = 0;
        // 들어온 secondWord에서 사전 제일 맨 앞에 나오는 단어 찾기
        for (int i = 0; i < nextWord.length(); i++) {
            char c = nextWord.charAt(i);
            if (c < compare2) {
                compare2 = c;
                secondStandard = i;
            }
        }
        String secondWord = nextWord.substring(0, secondStandard + 1);
        String lastWord = nextWord.substring(secondStandard + 1, nextWord.length());

        StringBuffer sbf = new StringBuffer(firstWord);
        String reversed1 = sbf.reverse().toString();
        sbf = new StringBuffer(secondWord);
        String reversed2 = sbf.reverse().toString();
        sbf = new StringBuffer(lastWord);
        String reversed3 = sbf.reverse().toString();

        bw.write(reversed1 + reversed2 + reversed3);
        bw.flush();
        bw.close();

    }
}
