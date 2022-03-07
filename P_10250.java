import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum;
        int []height, width, visitor;

        testNum = Integer.parseInt(br.readLine());

        height = new int[testNum];
        width = new int[testNum];
        visitor = new int[testNum];

        String s;
        StringTokenizer st;
        for(int i = 0; i < testNum; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);

            height[i] = Integer.parseInt(st.nextToken());
            width[i] = Integer.parseInt(st.nextToken());
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        String roomH, roomW;
        for(int i = 0; i < testNum; i++) {
            roomH = Integer.toString(visitor[i] % height[i]);
            if(roomH.equals("0")) {
                roomH = Integer.toString(height[i]);
            }
            roomW = Integer.toString((int)Math.ceil(((double)visitor[i] / (double)height[i])));
            if(roomW.length() == 1) {   // 어차피 w는 100미만이니까
                roomW = "0" + roomW;
            }
            
            System.out.println(roomH + roomW);
        }

        return ;
    }
}