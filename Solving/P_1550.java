package Solving;
// 16진수 1550
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        System.out.println(Integer.parseInt(input, 16));
    }
}
