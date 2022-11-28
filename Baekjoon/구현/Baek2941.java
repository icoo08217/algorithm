package 구현;

import java.io.*;

public class Baek2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == 'c') {
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == '=') {
                        i++; // c= 가 한 단어이므로 = 의 자리는 건너 뛰어야 한다.
                    } else if (word.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            }

            else if(c == 'd'){
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == 'z') {
                        if (i < word.length() - 2) {
                            if (word.charAt(i + 2) == '=') {
                                i += 2; // dz= 가 한단어 이므로 z=의 자리를 건너 뛰어야 하므로 i + 2 를 더해준다.
                            }
                        }
                    }
                    else if (word.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            }

            else if(c == 'l'){
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            }

            else if(c == 'n'){
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            }

            else if(c == 's'){
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == '=') {
                        i++;
                    }
                }
            }

            else if(c == 'z'){
                if (i < word.length() - 1) {
                    if (word.charAt(i + 1) == '=') {
                        i++;
                    }
                }
            }

            count++;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
