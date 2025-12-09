import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        move(0,arr);
        System.out.println(max);
    }

    static void move(int moveCnt, int[][] arr) {
        if (moveCnt == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    max = Math.max(arr[i][j], max);
            }
            return;
        }

        int[][] tmp;
        tmp = copyArray(arr);
        moveTop(tmp);
        move(moveCnt+1,tmp);

        tmp = copyArray(arr);
        moveBottom(tmp);
        move(moveCnt+1,tmp);

        tmp = copyArray(arr);
        moveLeft(tmp);
        move(moveCnt+1,tmp);

        tmp = copyArray(arr);
        moveRight(tmp);
        move(moveCnt+1,tmp);
    }

    static int[][] copyArray(int[][] arr){
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++)
            tmp[i] = arr[i].clone();
        return tmp;
    }

    static void moveTop(int[][] arr){
        for (int i = 0; i < n; i++) {
            int index = 0; // 블럭 넣을 위치
            int block = 0; // 최근 블록의 값
            for (int j = 0; j < n; j++) {
                if (arr[j][i] != 0) {
                    if (block == arr[j][i]) { // 최근 블록이랑 값이 같아서 합칠수있는 경우
                        arr[index - 1][i] = block * 2; //블록 합치기
                        block = 0;
                        arr[j][i] = 0;
                    }
                    else{ // 최근 블록의 값과 현재 값이 다르다면
                        block = arr[j][i]; //블록 값을 현재 블록값으로 갱신
                        arr[j][i] = 0; // 현재 블록 값을 0으로
                        arr[index][i] = block;
                        index++;
                    }
                }
            }
        }
    }

    static void moveBottom(int[][] arr){
        for (int i = 0; i < n; i++) {
            int index = n-1;
            int block = 0;
            for (int j = n-1; j >=0; j--) {
                if (arr[j][i] != 0) {
                    if (block == arr[j][i]) {
                        arr[index + 1][i] = block * 2;
                        block = 0;
                        arr[j][i] = 0;
                    }
                    else{
                        block = arr[j][i];
                        arr[j][i] = 0;
                        arr[index][i] = block;
                        index--;
                    }
                }
            }
        }
    }

    static void moveLeft(int[][] arr){
        for (int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    if (block == arr[i][j]) {
                        arr[i][index - 1] = block * 2;
                        block = 0;
                        arr[i][j] = 0;
                    }
                    else{
                        block = arr[i][j];
                        arr[i][j] = 0;
                        arr[i][index] = block;
                        index++;
                    }
                }
            }
        }
    }

    static void moveRight(int[][] arr){
        for (int i = 0; i < n; i++) {
            int index = n-1;
            int block = 0;
            for (int j = n-1; j >= 0; j--) {
                if (arr[i][j] != 0) {
                    if (block == arr[i][j]) {
                        arr[i][index + 1] = block * 2;
                        block = 0;
                        arr[i][j] = 0;
                    }
                    else{
                        block = arr[i][j];
                        arr[i][j] = 0;
                        arr[i][index] = block;
                        index--;
                    }
                }
            }
        }
    }
}