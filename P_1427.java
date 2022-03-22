// 소트인사이드 1427
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P_1427 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer []nums;
        String input = br.readLine();
        nums = new Integer[input.length()];

        for(int i = 0; i < input.length(); i++) {
            nums[i] = (int)input.charAt(i);
        }

        Arrays.sort(nums, Collections.reverseOrder());

        for(int i : nums) {
            sb.append(i - 48);
        }

        System.out.println(sb);
    }
}
