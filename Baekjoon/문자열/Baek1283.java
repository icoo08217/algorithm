package 문자열;

import java.io.*;
import java.util.HashMap;

// 단축키 지정
public class Baek1283 {

    static HashMap<Character, Integer> map = new HashMap<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            shortCut(cmd);
        }

        bw.flush();
        bw.close();
    }

    private static void shortCut(String cmd) throws IOException{
        String[] arr = cmd.split(" "); // 들어온 명령어를 나눔.
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (String s : arr) {
            char c = s.charAt(0);
            char lowerC = Character.toLowerCase(c);
            if (flag && map.getOrDefault(lowerC , 0) == 0 && lowerC != ' ') { // 지정된 단축키가 없음.
                map.put(lowerC, 1);  // 해당 단축키를 map에 넣는다.
                sb.append("[" + c + "]" + s.substring(s.indexOf(c) + 1) + " ");
                flag = false;
            }
            else {
                sb.append(s + " ");
            }
        }
        if (!flag){
            bw.write(sb + "\n");
        }
        else { // flag 가 계속 true라면 단축키로 지정할 첫번째 단어가 존재하지 않는다. 그로므로 다음 단어를 확인한다.
            String output = "";
            for (int i = 0; i < cmd.length(); i++) {
                char c = cmd.charAt(i);
                char lowerC = Character.toLowerCase(c);
                if (flag && map.getOrDefault(lowerC, 0) == 0 && lowerC != ' '){ // 저장된 단축키 없음.
                    map.put(lowerC, 1);
                    output += "[" + c + "]";
                    flag = false;
                }
                else {
                    output+=c;
                }
            }
            bw.write(output + "\n");
        }
    }
}
