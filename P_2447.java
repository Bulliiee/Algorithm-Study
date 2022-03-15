// 별찍기10 2447
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());

        for(int y = 0; y < input; y++) {
            sb.setLength(0);

            for(int x = 0; x < input; x++) {
                paintDot(input, x, y, sb);
            }
            System.out.println(sb);
        }
    }

    static void paintDot(int num, int x, int y, StringBuilder sb) {
        if((x / num) % 3 == 1 && (y / num) % 3 == 1) {
            sb.append(" ");
        }
        else {
            if(num / 3 == 0) {
                sb.append("*");
            }
            else {
                paintDot(num / 3, x, y, sb);
            }
        }
    }
}
