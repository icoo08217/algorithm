
import java.util.*;
import java.io.*;

class baek11656{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String arr[] = new String[input.length()];

        for (int i=0; i<input.length(); i++){
            arr[i] = input.substring(i);
        }

        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }


    }
}