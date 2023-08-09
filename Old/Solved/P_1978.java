package Solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int []nums = new int[number];
        for(int i = 0; i < number; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i = 0; i < number; i++) {
            if(nums[i] == 1) {  // 1예외처리
                continue;
            }
            count++;
            for(int j = 2; j < nums[i]; j++) {  // 1과 자신 제외 나누어지면 카운트 줄이기
                if((nums[i] % j) == 0) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
