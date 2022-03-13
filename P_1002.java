// 터렛 1002
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tNum = Integer.parseInt(br.readLine());
        // [0]: x1, [1]: y1, [2]: r1
        // [3]: x2, [4]: y2, [5]: r2
        int []input = new int[6];

        StringTokenizer st;
        double diff, sum;  // 두 점 사이 거리와 찾은거리 합
        for(int i = 0; i < tNum; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }

            diff = Math.sqrt(Math.pow(input[3] - input[0], 2) + Math.pow(input[4] - input[1], 2));
            sum = input[2] + input[5];

            if(diff == 0) {
                // 류재명 위치 무한(같은위치 터렛, 같은거리 류재명)
                if(input[2] == input[5]) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(0);
                }
                continue;
            }

            int bigR = Math.max(input[2], input[5]);
            int smallR = Math.min(input[2], input[5]);
            if(bigR == diff + smallR) { // 큰 원 안에 작은 원, 한 점 맞닿은 경우
                System.out.println(1);
            }
            else if(bigR > diff + smallR) { // 큰 원 안에 작은 원, 닿는곳 없는 경우
                System.out.println(0);
            }
            else if(diff < sum) {   // 원 두 개가 두 점에서 만나는 경우
                System.out.println(2);
            }
            else if(diff == sum) {  // 원 두 개가 한 점에서 만나는 경우
                System.out.println(1);
            }
            else if(diff > sum) {   // 원 두 개가 만나지 않는 경우
                System.out.println(0);
            }
        }
    }
}
