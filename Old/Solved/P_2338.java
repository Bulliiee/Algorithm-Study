package Solved;
// 긴자리 계산 2338
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P_2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger input1 = new BigInteger(br.readLine());
        BigInteger input2 = new BigInteger(br.readLine());

        sb.append(input1.add(input2) + "\n");
        sb.append(input1.subtract(input2) + "\n");
        sb.append(input1.multiply(input2));

        System.out.print(sb.toString());
    }
}
