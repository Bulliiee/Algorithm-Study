import java.util.*;
import java.io.*;

/**
 * BJ_11265_끝나지않는파티_이항우.java
 * 
 * 
 * @author 이항우
 *
 */
public class Main {

	static int size, customerNum;
	static int[][] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		customerNum = Integer.parseInt(st.nextToken());
		party = new int[size+1][size+1];	// 0번 파티장 없음
		
		for(int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= size; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getTakeTime();
		
		for(int i = 0; i < customerNum; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			if(party[src][dest] <= time) {
				sb.append("Enjoy other party\n");
			}
			else {
				sb.append("Stay here\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static void getTakeTime() {
		for(int k = 1; k <= size; k++) {
			for(int i = 1; i <= size; i++) {
				for(int j = 1; j <= size; j++) {
					party[i][j] = Integer.min(party[i][j], party[i][k] + party[k][j]);
				}
			}
		}
		
	}

}