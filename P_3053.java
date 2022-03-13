// 택시 기하학 3053
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double r = Double.parseDouble(br.readLine());

        // 유클리드: 평소 계산하던대로 pi * r^2
        //          어떤 점에서 거리가 일정한 점들의 집합이 무수히 많음
        // 택시: 점과 점 사이를 대각으로 재는게 아니라 택시 경로처럼 계단형으로 거리를 잼
        //       그래서 어떤 점에서 거리가 일정한 점들의 집합이 총 4개 나타남
        //       그 점 4개를 이으면 마름모 형태가 나옴
        //       결론: 택시기하학 원 넓이 = 반지름 * 2를 대각길이로 하는 정사각형 넓이
        //       마름모 넓이 구하는 공식((대각길이 * 다른대각길이) / 2)에 의해 ((2*r) * (2*r)) / 2
        //       넓이 = 2 * r^2
        double res1 = Math.PI * Math.pow(r, 2);
        double res2 = 2.0 * Math.pow(r, 2);

        sb.append(res1 + "\n" + res2);
        System.out.println(sb);
    }
}
