import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2869 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String tempS = br.readLine();
        st = new StringTokenizer(tempS);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int count = 0;

        count = (v - a) / (a - b);
        if((v - a) % (a - b) != 0) {
            count++;
        }
        count++;    // 마지막 올라가기만 하는거 하루 체크(위의 v -= a로 뺐음)
        
        System.out.println(count);
        
        br.close();
        return ;
    }
}