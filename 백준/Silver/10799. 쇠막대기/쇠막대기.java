import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        int result = 0;
        int openBars = 0; // 열린 막대기 수
        char prev =' ';
        // 레이저면 앞괄호가 (
        // 바면 앞괄호가 )
        for(int i=0; i<cmd.length(); i++){
            char c = cmd.charAt(i);
            if(c=='(')
                openBars++;
            else{
                openBars--;
                if(prev=='(') result+=openBars; //레이저 -> 열린 막대기만큼 조각 수 카운트
                else result +=1; //바 -> 마지막 조각 수 카운트

            }
            prev = c; //이전문자 저장
        }
        System.out.println(result);
    }
}