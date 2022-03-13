// 직각삼각형 4153
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int []input = new int[3];
        while(true) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            if(input[0] == 0 && input[1] == 0 && input[2] == 0) {
                break;
            }

            input = sort(input);

            if(Math.pow(input[0], 2) + Math.pow(input[1], 2) == Math.pow(input[2], 2)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }

    }

    static int []sort(int []input) {
        int temp = 0;

        for(int i = 0; i < input.length; i++) {
            for(int j = i + 1; j < input.length; j++) {
                if(input[i] > input[j]) {
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        
        return input;
    }
}