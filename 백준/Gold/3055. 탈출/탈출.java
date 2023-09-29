import java.util.*;
import java.io.*;

/**
 * 지도: R행C열 / .: 빈곳 / *: 물 / X: 돌 / D: 비버 굴 / S: 고슴도치
 * 매 분	- 고슴도치: 상하좌우 이동가능
 * 		- 물: 물 있는 칸과 인접한 칸 물로 채워짐
 * 물은 돌 통과 못함
 * 고슴도치는 돌, 물(물이 찰 예정인 곳 포함) 통과 못함
 * 물은 비버 소굴 x
 * 
 * 고슴도치가 비버굴로 이동 위한 최소 시간?
 * 
 * BFS로 하면 된다.
 * 근데 고슴도치는 물이 찰 예정인 곳 갈 수 없으니 물을 먼저 퍼뜨리고 고슴도치 이동시키면 될 것 같다.
 */
public class Main {

	static int sizeR, sizeC;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sizeR = Integer.parseInt(st.nextToken());
		sizeC = Integer.parseInt(st.nextToken());
		visited = new int[sizeR][sizeC];
		
		int[] dochi = null;
		int[] beaver = null;
		
		for(int i = 0; i < sizeR; i++) {
			String input = br.readLine();
			for(int j = 0; j < sizeC; j++) {
				char temp = input.charAt(j);
				// 고슴도치
				if(temp == 'S') {
					visited[i][j] = 1;
					dochi = new int[] {i, j};
				}
				// 물
				else if(temp == '*') {
					visited[i][j] = 10000;
					// 고슴도치랑 물을 같은 큐에 넣어도 visited의 숫자로 구분하면 된다.
					q.offer(new int[] {i, j});
				}
				// 돌
				else if(temp == 'X') {
					visited[i][j] = 10001;
				}
				// 비버 굴
				else if(temp == 'D') {
					beaver = new int[] {i, j};
				}
				
			}
		}
		
		// 고슴도치를 물 뒤에 넣어서 물 먼저 퍼지게 한다.
		q.offer(dochi);
		
		int res = bfs(beaver);
		System.out.println(res == 0 ? "KAKTUS" : res);
	}
	
	static int bfs(int[] beaver) {
		boolean isWater = false;

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			// 큐에서 꺼낸애가 물인 경우
			if(visited[curr[0]][curr[1]] == 10000) {
				isWater = true;
			}
			// 고슴도치인 경우(어차피 물 아니면 고슴도치 좌표만 들어있음)
			else {
				isWater = false;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(0 <= nr && nr < sizeR && 0 <= nc && nc < sizeC && visited[nr][nc] == 0) {
					// 물
					if(isWater) {
						// 비버 굴 아닐 때만
						if(nr != beaver[0] || nc != beaver[1]) {
							visited[nr][nc] = 10000;
							q.offer(new int[] {nr, nc});
						}
					}
					else {	// 고슴도치
//						System.out.println("nr, nc: " + nr + ", " + nc);
//						System.out.println("beaver: " + beaver[0] + ", " + beaver[1]);
						
						// 고슴도치가 비버굴 도착한 경우
						if(nr == beaver[0] && nc == beaver[1]) {
							return visited[curr[0]][curr[1]];
						}
						
						visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
						q.offer(new int[] {nr, nc});
					}
					
//					System.out.println("==========");
//					for(int a = 0; a < sizeR; a++) {
//						for(int b = 0; b < sizeC; b++) {
//							System.out.print(visited[a][b] + "\t");
//						}
//						System.out.println();
//					}
				}
			}
			
		}
		
		return 0;
	}
	
}