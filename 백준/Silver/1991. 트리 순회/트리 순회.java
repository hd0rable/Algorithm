import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] l = new int[27];
    static int[] r = new int[27];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node, ln, rn;
            node = st.nextToken().charAt(0);
            ln = st.nextToken().charAt(0);
            rn = st.nextToken().charAt(0);
            if(ln!='.') l[node-'A'+1] = ln-'A'+1;
            if(rn!='.') r[node-'A'+1] = rn-'A'+1;
        }
        preorder(1); sb.append('\n');
        inorder(1); sb.append('\n');
        postorder(1); sb.append('\n');
        System.out.print(sb);
    }
    
    static void preorder(int cur){
        sb.append((char)(cur+'A'-1));
        if(l[cur]!=0) preorder(l[cur]);
        if(r[cur]!=0) preorder(r[cur]);
    }

    static void inorder(int cur){
        if(l[cur]!=0) inorder(l[cur]);
        sb.append((char)(cur+'A'-1));
        if(r[cur]!=0) inorder(r[cur]);
    }

    static void postorder(int cur){
        if(l[cur]!=0) postorder(l[cur]);
        if(r[cur]!=0) postorder(r[cur]);
        sb.append((char)(cur+'A'-1));
    }

}