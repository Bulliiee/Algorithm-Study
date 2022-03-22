package Solved;
// 엄청난 부자2 1271
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P_1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수가 엄청 커서 BigInteger 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger money = new BigInteger(st.nextToken());
        BigInteger life = new BigInteger(st.nextToken());

        BigInteger res1 = money.divide(life);
        sb.append(res1 + "\n");
        res1 = money.remainder(life);
        sb.append(res1);
        System.out.println(sb);
    }
}
