package Solved;
// 덩치 7568
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int []weight = new int[num]; 
        int []height = new int[num];
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i = 0; i < num; i++) {
            count = 0;
            for(int j = 0; j < num; j++) {
                if(weight[i] < weight[j] && height[i] < height[j]) {
                    count++;
                }
            }
            sb.append(count + 1 + " ");
        }

        System.out.println(sb);
    }
}
