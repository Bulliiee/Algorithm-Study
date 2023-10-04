import java.io.*;
import java.util.*;

/**
 * 플로이드 워셜을 사용해서 각 학생들로부터 다른 학생까지 도달 여부를 표시한다.
 * 어떤 한 학생 a에 대해 INF가 있다면, 그 INF인 학생으로부터 a까지 갈 수 있는지 여부를 확인해서 된다면 자기 자신의 순위를 알 수 있는것이다.  
 *
 */
public class Solution {
	
	final static int INF = Integer.MAX_VALUE/2;
	
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int res = 0;
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			// 인접행렬로 입력
			map = new int[N+1][N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int src = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				map[src][dest] = 1;
			}
			// INF설정
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i != j && map[i][j] == 0) {
						map[i][j] = INF;
					}
				}
			}
			
			// 플로이드 워셜
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
			// 자기 키 몇번째인지 아는지 여부 체크
			// 어떤 한 학생 a에 대해 INF가 있다면, 그 INF인 학생으로부터 a까지 갈 수 있는지 여부를 확인해서 
			// 된다면 자기 자신의 순위를 알 수 있는것이다.
			for(int i = 1; i <= N; i++) {
				boolean isKnow = true;
				for(int j = 1; j <= N; j++) {
					if(map[i][j] == INF) {
						if(map[j][i] == INF) {
							isKnow = false;
							break;
						}
					}
				}
				
				if(isKnow) {
					res++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	

}

