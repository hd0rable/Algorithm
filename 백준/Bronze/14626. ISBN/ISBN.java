import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cmd = br.readLine();

        int result = 0;
        int starWeight = 0;
        for(int i=0; i<12; i++) {
            int weight = (i % 2 == 0) ? 1 : 3;
            if (cmd.charAt(i) == '*')
                starWeight = weight;
            else result += (cmd.charAt(i) - '0') * weight;
        }

        int check = cmd.charAt(12) - '0';
        for(int i=0; i<=9; i++) {
            if ((result + (i * starWeight) + check) % 10 == 0) {
                System.out.print(i);
                return;
            }
        }
    }
}
