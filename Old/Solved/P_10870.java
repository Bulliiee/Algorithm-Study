package Solved;
// 피보나치 수 5(재귀) 10870
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(fibonacci(Integer.parseInt(br.readLine())));
    }

    static int fibonacci(int num) {
        if(num == 0) {
            return 0;
        }
        if(num == 1) {
            return 1;
        }

        return fibonacci(num - 2) + fibonacci(num - 1);
    }
}
