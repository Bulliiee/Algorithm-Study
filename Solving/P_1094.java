package Solving;
// 막대기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        String bin = Integer.toBinaryString(input);

        int count = 0;
        for(int i = 0; i < bin.length(); i++) {
            if(bin.charAt(i) == '1') {
                count++;
            }
        }

        System.out.println(count);
    }
}
