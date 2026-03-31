import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        for(int i=1; i<=3; i++) {
            String cmd = br.readLine();
            if ('0' < cmd.charAt(0) && cmd.charAt(0) <= '9')
                num = Integer.parseInt(cmd) + (4 - i);
        }

        if(num%3==0 && num%5==0)
            System.out.print("FizzBuzz");
        else if(num%3==0)
            System.out.print("Fizz");
        else if(num%5==0)
            System.out.print("Buzz");
        else System.out.print(num);

    }
}
