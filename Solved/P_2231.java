package Solved;
// 분해합 2231
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int compareNum = 0;
        int res = 0;


        while(compareNum < input) {
            int temp = compareNum;

            res = compareNum;
            for(int i = 0; i < Integer.toString(compareNum).length(); i++) {
                res += temp % 10;
                temp /= 10;
            }
            // System.out.println("res: " + res + ", compareNum: " + compareNum);

            if(res == input) {
                break;
            }
            compareNum++;
        }
        
        if(compareNum == input) {
            compareNum = 0;
        }

        System.out.println(compareNum);
    }
}
