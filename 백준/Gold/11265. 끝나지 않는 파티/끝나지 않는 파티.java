import java.util.*;
import java.io.*;

public class Main {

	static int size, customerNum;
	static int[][] party;
	
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		customerNum = Integer.parseInt(st.nextToken());
		party = new int[size+1][size+1];	// 0번 파티장 없음
		distance = new int[size+1][size+1];	// 0번 파티장 없음
		
		for(int i = 1; i <= size; i++) {
			Arrays.fill(distance[i], 1_000_000_001);
		}
		
		for(int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= size; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getTakeTime();
//		System.out.println();
//		for(int i = 1; i <= size; i++) {
//			for(int j = 1; j <= size; j++) {
//				System.out.print(distance[i][j] + " ");
//			}
//			System.out.println();
//		}
		
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