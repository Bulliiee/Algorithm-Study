import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Solution {
	
	static int[][] rooms;	// 방
	static int N;			// 방 갯수
	
	static boolean[][] visited;		// 방문 여부 확인용 배열
	
	// 좌표가 범위 안인지 확인한다.
	static boolean isOk(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		
		return true;
	}
	
	// dfs로 각 방 탐색
	static int getGoodStart(int r, int c, int roomMoveCount) {
		// 방문
		visited[r][c] = true;
		roomMoveCount++;
		
		int[] moveC = {-1, 1, 0, 0};	// 좌우
		int[] moveR = {0, 0, -1, 1};	// 상하
		
		// 현재 좌표에 대해 사방 탐색
		for(int i = 0; i < 4; i++) {
			int nextR = r + moveR[i];
			int nextC = c + moveC[i];
			
			// 아래 조건이 재귀 종료 조건이 됨
			// 다음 좌표가 범위 안이고 방문 안했으며
			if(isOk(nextR, nextC) && !visited[nextR][nextC]) {	
				// 방문할 수 있는 방이면
				if(rooms[r][c] + 1 == rooms[nextR][nextC]) {
					// 재귀 호출
					roomMoveCount = getGoodStart(nextR, nextC, roomMoveCount);
				}
			}
		}
		
		return roomMoveCount;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테케 수
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());	// 방 크기 입력받기
			rooms = new int[N][N];					// N x N방
			// 각 방 입력받기
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxRoom = Integer.MAX_VALUE;	// 최대로 움직일 수 있는 시작방
			int maxCount = 0;					// 최대로 움직일 수 있는 양
			// 각 좌표에 대해 dfs를 실시한다.
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new boolean[N][N]; // 방문 여부 확인용 배열 초기화 위함
					int currMoveCount = getGoodStart(i, j, 0);
					if(maxCount < currMoveCount) {
						maxCount = currMoveCount;
						maxRoom = rooms[i][j];
					}
					else if(maxCount == currMoveCount) {
						if(maxRoom > rooms[i][j]) {
							maxCount = currMoveCount;
							maxRoom = rooms[i][j];
						}
						
					}
				}
			}
			
			sb.append("#" + tc + " " + maxRoom + " " + maxCount + "\n");
		}

		System.out.print(sb.toString());
	}

}
