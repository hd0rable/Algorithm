import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = line.charAt(j);
            }
        }
        func(n,0,0);
        System.out.println(sb);
    }

    static void func(int size, int row, int col){
        if(isSame(size,row,col)){
            sb.append(board[row][col]-'0');
            return;
        }
        int newSize = size/2;
        for(int i=0; i<2; i++){
            if(i==0) sb.append('(');
            for(int j=0; j<2; j++){
                func(newSize,row+(i*newSize),col+(j*newSize));
            }
        }
        sb.append(')');
    }

    static boolean isSame(int size, int row, int col){
        int val = board[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(val!=board[i][j]) return false;
            }
        }
        return true;
    }
}