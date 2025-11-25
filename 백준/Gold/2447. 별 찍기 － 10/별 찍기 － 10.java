import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static char[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        initBoard();
        func(n,0,0);
        for(int i=0; i<n; i++)
            sb.append(board[i]).append('\n');
        System.out.println(sb);
    }

    static void func(int n, int x, int y){
        if(n==1) {
            board[x][y] = '*';
            return;
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1&&j==1) continue;
                func(n/3, x+ n/3*i, y + n/3*j);
            }
        }
    }

    static void initBoard() {
        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], ' ');
        }
    }


}