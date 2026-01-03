import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        // - 기준으로 먼저 나누기
        String[] str = line.split("-");

        int min = 0;
        for(int i=0; i<str.length; i++) {
            int sum = 0;
            String[] tmp = str[i].split("\\+");
            for(String num : tmp){
                sum += Integer.parseInt(num);
            }
            if(i==0) min += sum;
            else min -= sum;
        }
        System.out.println(min);
    }
}