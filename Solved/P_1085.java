package Solved;
// 직사각형에서 탈출 1085
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int []input = new int[4];   // 0: x, 1: y, 2: w, 3: h

        for(int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int min1 = Math.min(input[0], input[1]);
        int min2 = Math.min(input[3] - input[1], input[2] - input[0]);
        int min = Math.min(min1, min2);

        System.out.println(min);
    }
    
}