import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Pos> cctv = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0 && arr[i][j]!=6) {
                    cctv.add(new Pos(i,j));
                }
            }
        }

        func(0,arr);
        System.out.println(min);
    }

    static void func(int cctvIdx, int[][] curArr){
        if(cctvIdx == cctv.size()){
            int cnt = counting(curArr);
            min = Math.min(cnt,min);
            return;
        }

        Pos pos = cctv.get(cctvIdx);
        int x = pos.getX();
        int y = pos.getY();
        int[][] tmp ;
        switch(arr[x][y]){
            case 1: {
                tmp = copyArray(curArr);
                toRight(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toBottom(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toLeft(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toTop(x,y,tmp);
                func(cctvIdx+1,tmp);
                break;
            }
            case 2: {

                tmp = copyArray(curArr);
                toLeft(x,y,tmp);
                toRight(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toBottom(x,y,tmp);
                toTop(x,y,tmp);
                func(cctvIdx+1,tmp);
                break;
            }
            case 3: {
                tmp = copyArray(curArr);
                toTop(x,y,tmp);
                toRight(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toRight(x,y,tmp);
                toBottom(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toLeft(x,y,tmp);
                toBottom(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toLeft(x,y,tmp);
                toTop(x,y,tmp);
                func(cctvIdx+1,tmp);

                break;
            }
            case 4: {
                tmp = copyArray(curArr);
                toTop(x,y,tmp);
                toRight(x,y,tmp);
                toLeft(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toRight(x,y,tmp);
                toLeft(x,y,tmp);
                toBottom(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toRight(x,y,tmp);
                toTop(x,y,tmp);
                toBottom(x,y,tmp);
                func(cctvIdx+1,tmp);

                tmp = copyArray(curArr);
                toLeft(x,y,tmp);
                toTop(x,y,tmp);
                toBottom(x,y,tmp);
                func(cctvIdx+1,tmp);
                break;
            }
            case 5: {
                tmp = copyArray(curArr);
                toLeft(x,y,tmp);
                toRight(x,y,tmp);
                toTop(x,y,tmp);
                toBottom(x,y,tmp);
                func(cctvIdx+1,tmp);
                break;
            }
        }
    }

    static void toLeft(int x, int y ,int[][] tmp){
        for(int i=y-1; i>=0; i--){ //왼쪽 감시
            if(tmp[x][i] == 6) break;
            if(tmp[x][i] == 0) tmp[x][i] = -1;
        }
    }
    
    static void toRight(int x, int y, int[][] tmp){
        for(int i=y+1; i<m; i++) { //오른쪽 감시
            if(tmp[x][i] == 6) break;
            if(tmp[x][i] == 0) tmp[x][i] = -1;
        }
    }
    
    static void toBottom(int x, int y, int[][] tmp){
        for(int i=x+1; i<n; i++) { //아래 감시
            if(tmp[i][y] == 6) break;
            if(tmp[i][y] == 0) tmp[i][y] = -1;
        }
    }
    

    static void toTop(int x, int y, int[][] tmp){
        for(int i=x-1; i>=0; i--) { //위 감시
            if(tmp[i][y] == 6) break;
            if(tmp[i][y] == 0) tmp[i][y] = -1;
        }
    }
    
    static int[][] copyArray(int[][] arr){
        int[][]tmp = new int[n][m];
        for(int i=0; i<n; i++) tmp[i] = arr[i].clone();
        return tmp;
    }

    static int counting(int[][] arr){
        int cnt =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if (arr[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static class Pos {
        int x;
        int y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        int getX(){
            return this.x;
        }

        int getY(){
            return this.y;
        }
    }
    
}