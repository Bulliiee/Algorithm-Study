package Solved;
// 최대공약수와 최소공배수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        
        int gcd = getGCD(num1, num2);
        sb.append(gcd).append('\n');
        sb.append(num1 * num2 / gcd);

        System.out.println(sb);
    }

    static int getGCD(int num1, int num2) {
        int gcd = 0;
        int min = Math.min(num1, num2);
        for(int i = 1; i <= min; i++) {
            if(num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
