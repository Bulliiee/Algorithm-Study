import java.util.*;
import java.io.*;

/**
 *
 */
public class Main {
	
	static int T;
	static int convNum;
	
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			convNum = Integer.parseInt(br.readLine());
			
			// [0][]: 집, [convNum+1][]: 페스티벌 장소, 나머지: 편의점
			int[][] points = new int[convNum+2][2];
			for(int i = 0; i < convNum+2; i++) {
				st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			
			map = new int[convNum+2][convNum+2];
			for(int i = 0; i < convNum+2; i++) {
				for(int j = 0; j < convNum+2; j++) {
					if(i == j) {
						map[i][j] = 0;
					}
					else {
						int distance = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]); 
						// 맥주 한 박스로 갈 수 있으면
						if(distance <= 1000) {
							map[i][j] = 1;
						}
						else {
							map[i][j] = Integer.MAX_VALUE/2;
						}
					}
				}
			}
			
			for(int k = 0; k < convNum+2; k++) {
				for(int i = 0; i < convNum+2; i++) {
					if(i != k) {
						for(int j = 0; j < convNum+2; j++) {
							if(j != k && i != j) {
								map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
							}
						}
					}
				}
			}
			
			if(map[0][convNum+1] != Integer.MAX_VALUE/2) {
				sb.append("happy\n");
			}
			else {
				sb.append("sad\n");
			}
			
		}
		System.out.println(sb.toString());
	}
	
}