package Solved;
// 수열의 변화
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int []nums = new int[n];
        st = new StringTokenizer(br.readLine(), ",");
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = n;
        for(int i = 0; i < k; i++) {
            count--;
            getSequence(nums, count);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count - 1; i++) {
            sb.append(nums[i]).append(',');
        }
        sb.append(nums[count - 1]);

        System.out.println(sb);
    }

    static void getSequence(int []nums, int count) {
        for(int i = 0; i < count; i++) {
            nums[i] = nums[i + 1] - nums[i];
        }
    }

}
