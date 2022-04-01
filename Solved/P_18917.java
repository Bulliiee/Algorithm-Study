package Solved;
// 수열과 쿼리 38
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_18917 {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int input = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int query;
        long num;
        long sum = 0;
        long xor = 0;
        for(int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            query = Integer.parseInt(st.nextToken());

            switch(query) {
                case 1:
                    num = Long.parseLong(st.nextToken());
                    sum += num;
                    xor ^= num;
                    break;
                case 2:
                    num = Long.parseLong(st.nextToken());
                    sum -= num;
                    xor ^= num;
                    break;
                case 3:
                    sb.append(sum).append('\n');
                    break;
                case 4:
                    sb.append(xor).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}
