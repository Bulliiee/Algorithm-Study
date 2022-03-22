package Solved;
// 팩토리얼 10872 (for문 말고 재귀 사용)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = factorial(Integer.parseInt(br.readLine()));

        System.out.println(res);
    }

    static int factorial(int num) {
        if(num == 0) {
            return 1;
        }
        
        if(num == 1) {
            return num;
        }

        return num *= factorial(num - 1);
    }   
}