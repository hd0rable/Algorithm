import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] tokens = line.split(" ");
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) descending = false;
            else if (arr[i] > arr[i + 1]) ascending = false;
        }

        if (ascending) System.out.println("ascending");
        else if (descending) System.out.println("descending");
        else System.out.println("mixed");

    }
}