//https://www.acmicpc.net/problem/1193
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int line = 1; //현재 라인 번호
        int count = 0; //현재 라인까지 누적 개수
        while(true){
            if(x <= count + line){
                int pos = x - count; //라인 내에서 순서
                int n = line - pos + 1; //짝이되는 수

                StringBuilder sb = new StringBuilder();
                if (line % 2 == 0) {
                    // 짝수 라인: 위에서 아래로 (pos/n)
                    sb.append(pos).append('/').append(n);
                } else {
                    // 홀수 라인: 아래에서 위로 (n/pos)
                    sb.append(n).append('/').append(pos);
                }
                System.out.println(sb);
                break;
            }
            count += line;
            line++;
        }


    }
}