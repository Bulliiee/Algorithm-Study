// 네 번째 점 3009
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [][]point = new int[4][2];
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 2; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 2; i++) {
            if(point[0][i] == point[1][i]) {
                point[3][i] = point[2][i];
            }
            else if(point[0][i] == point[2][i]) {
                point[3][i] = point[1][i];
            }
            else {
                point[3][i] = point[0][i];
            }
        }

        sb.append(point[3][0] + " " + point[3][1]);
        System.out.println(sb);
    }
}
