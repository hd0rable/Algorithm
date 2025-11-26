import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n;
    static String[] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        star = new String[n];
        //k=0 일때 기본 별모양
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";
        for(int i=1; 3*Math.pow(2,i) <=n; i++)
            writeStar(i);

        for(int i=0; i<n; i++)
            sb.append(star[i]).append('\n');
        System.out.println(sb);
    }

    //k값 점화식을 통해 별 찍기
    static void writeStar(int i){
        int bottom = (int) (3*Math.pow(2,i)); //아리 최대 행
        int middle = bottom/2; //위와 아래를 구분하는 행
        // 아래부분 대응하는 별에 점화식 적용
        for(int j=middle; j<bottom; j++)
            star[j] = star[j-middle] + " " + star[j-middle];
        String blank = " ".repeat(middle);
        // 위부분에 대응하는 별에 빈칸 추가
        for(int j=0; j<middle; j++)
            star[j] = blank + star[j] + blank;
    }

}