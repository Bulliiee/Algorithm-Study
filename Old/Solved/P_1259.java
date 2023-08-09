package Solved;
// 팰린드롬수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = null;
        int length;
        boolean check = true;
        while(true) {
            input = br.readLine();
            if(input.equals("0")) {
                break;
            }
            length = input.length();
            check = true;

            for(int i = 0; i < length / 2; i++) {
                if(input.charAt(i) != input.charAt(length - i - 1)) {
                    sb.append("no").append('\n');
                    check = false;
                    break;
                }
            }

            if(check) {
                sb.append("yes").append('\n');
            }
        }

        System.out.println(sb);
    }
}
