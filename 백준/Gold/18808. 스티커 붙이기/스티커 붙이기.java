import java.io.*;
import java.util.*;

public class Main {
    static int ln;
    static int lm;
    static int k;
    static int[][] laptop;
    static int[][] sticker;
    static int sn;
    static int sm;
    static int cnt =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ln = Integer.parseInt(st.nextToken());
        lm = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        laptop = new int[ln][lm];

        while(k-->0){
            st = new StringTokenizer(br.readLine());
            sn = Integer.parseInt(st.nextToken());
            sm = Integer.parseInt(st.nextToken());
            sticker = new int[sn][sm];

            for(int i = 0; i< sn; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < sm; j++)
                    sticker[i][j] = Integer.parseInt(st.nextToken());
            }

            int repeatCnt = 4;
            while(repeatCnt--> 0) {
                if(checkAttach()) break;
                // 스티커 회전하기
                sticker = turnSticker();
            }
        }
        counting();
        System.out.println(cnt);
    }

    static void counting(){
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < lm; j++) {
                if (laptop[i][j] == 1) {
                    cnt++;
                }
            }
        }
    }

    static boolean checkAttach(){
        // 회전없이 붙일수있는지 확인
        for (int i = 0; i <= ln - sn; i++) {
            for (int j = 0; j <= lm - sm; j++) {
                if (isAttach(i, j)) {
                    attachSticker(i, j);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isAttach(int x, int y){
        // 스티커의 행열 크기만큼 반복
        for(int si = 0; si < sn; si++){
            for(int sj = 0; sj < sm; sj++){
                // 노트북 인덱스 계산
                int li = x + si;
                int lj = y + sj;
                if(sticker[si][sj] == 1 && laptop[li][lj] == 1) {
                    //스티커가 위치하는 곳에 노트북에 이미 스티커가 붙어져있음
                    return false;
                }
            }
        }
        return true;
    }

    static void attachSticker(int x, int y){
        for(int si = 0; si < sn; si++) {
            for (int sj = 0; sj < sm; sj++) {
                if(sticker[si][sj] == 1)
                    laptop[x + si][y + sj] = 1;
                }
            }
    }

    static int[][] turnSticker(){
        int[][] tmp = new int[sm][sn];

        for(int i = 0; i< sn; i++){
            for(int j = 0; j< sm; j++){
                tmp[j][sn -1-i] = sticker[i][j];
            }
        }

        int tmp_ = sm;
        sm = sn;
        sn = tmp_;

        return tmp;
    }
}