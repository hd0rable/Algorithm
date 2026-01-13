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
                int n = line - pos + 1;
                if(line % 2 ==0){
                    System.out.print(pos);
                    System.out.print('/');
                    System.out.print(n);

                }else{
                    System.out.print(n);
                    System.out.print('/');
                    System.out.print(pos);
                }
                break;
            }
            count += line;
            line++;
        }
    }
}