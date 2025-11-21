import java.io.*;
import java.util.*;

public class Main {
    static int cnt_n1 =0;
    static int cnt_0 =0;
    static int cnt_p1 =0;
    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(n,0,0);
        System.out.println(cnt_n1);
        System.out.println(cnt_0);
        System.out.println(cnt_p1);
    }

    static void func(int size, int row, int col){
        if(allSame(size,row,col)) { //사이즈내의 값이 모두 같은지 체크
            counting(board[row][col]); //같다면 기준값 기준으로 카운팅
            return;
        }
        int newSize = size/3;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){ //같지않다면 쪼개기
                func(newSize,row + (i*newSize), col + (j*newSize));
            }
        }
    }

    static boolean allSame(int size, int row, int col){
        int val = board[row][col];
        for(int i =row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(board[i][j]!=val)
                    return false;
            }
        }
        return true;
    }

    static void counting(int val){
        switch(val){
            case -1 : cnt_n1++; break;
            case 0 : cnt_0++; break;
            case 1 : cnt_p1++; break;
        }
    }



}