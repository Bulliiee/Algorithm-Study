import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int caseNum;
        int k, n;

        caseNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < caseNum; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            sb.append(getNums(k, n)).append("\n");
        }
        
        System.out.println(sb);

        return ;
    }

    static int getNums(int k, int n) {
        if(n == 0) {
            return 0;
        }
        else if(k == 0) {
            return n;
        }
        else {
            return getNums(k - 1, n) + getNums(k, n - 1);
        }
    }
}
