package Solved;
// 카드 게임 5522
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_5522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int []input = new int[5];
        for(int i = 0; i < 5; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        for(int i = 0; i < 5; i++) {
            res += input[i];
        }

        System.out.println(res);
    }
}
