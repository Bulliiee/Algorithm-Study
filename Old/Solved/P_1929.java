package Solved;
// 소수구하기 1929
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num1, num2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        
        if(num1 == 1) {
            num1++;
        }

        while(num1 <= num2) {
            if(isPrime(num1)) {
                sb.append(num1 + "\n");
            }
            num1++;
        }

        System.out.print(sb);
    }

    static boolean isPrime(int num) {
        int temp = (int)Math.sqrt(num); // 에라토스테네스의 체-> 제곱근까지만 하면 더 빠름

        for(int i = 2; i <= temp; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
