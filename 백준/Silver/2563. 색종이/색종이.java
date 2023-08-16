import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] bigPaper = new int[100][100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int paperNum = Integer.parseInt(br.readLine());
		for(int rep = 0; rep < paperNum; rep++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			for(int i = row; i < row + 10; i++) {
				for(int j = col; j < col + 10; j++) {
					bigPaper[i][j]++;
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(bigPaper[i][j] != 0) {
					result++;
				}
			}
		}
		
		System.out.print(result);
	}
	
}
