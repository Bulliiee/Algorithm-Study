package Solved;
// 이항계수 1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int temp1 = 1;
        int temp2 = 1;
        for(int i = 1; i <= k; i++) {
            temp1 *= n;
            n--;

            temp2 *= i;
        }

        System.out.println(temp1 / temp2);
    }
}
