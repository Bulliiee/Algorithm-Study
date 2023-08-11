package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D4_SW문제해결기본2일차_Ladder1_이항우.java
 * 메모리:26276 KB
 * 시간:143 ms
 * 
 * 위에서부터 보면 여러번 봐야하니까 아래에서 2를 먼저 찾고, 거기부터 위로 올라가도록 한다
 * 
 * @author 이항우
 *
 */
public class D4_1210 {

	static int[][] ladder = new int[100][100];	// 입력받을 사다리
	
	static int getStartPoint(boolean[][] visited, int currX, int currY) {
		int[] moveX = {0, -1, 1};	// 왼쪽 오른쪽 움직임
		int[] moveY = {-1, 0, 0};	// 위쪽 움직임
		int direction = 0;	// 0: 위로, 1; 왼쪽, 2: 오른쪽 / move 배열들과 순서 맞춤
		
		while(true) {
			// 종료조건
			if(currY == 0) {
				break;
			}
			
			// 현재 방문 표시
			visited[currY][currX] = true;
			
			// 현재 가는 길 양쪽 체크 후 방향 설정
			for(int i = 1; i <= 2; i++) {
				int nextX = currX + moveX[i];
				// 사다리 범위 안이고
				if(0 <= nextX && nextX < 100) {
					// 왼쪽 혹은 오른쪽에 길이 있으며 방문하지 않았다면
					if(ladder[currY][nextX] == 1 && !visited[currY][nextX]) {
						direction = i;	// 방향 정하기
						break;
					}
					else {	// 길이 있지도 않거나 방문했다면 위로 올라가기
						direction = 0;
					}
				}
			}
			
			// 방향에 따른 움직임
			currX += moveX[direction];
			currY += moveY[direction];
		}
		
		return currX;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int rep = 10;	// 반복횟수
		int currX = 0, currY = 0;
		while(rep-- > 0) {
			int tc = Integer.parseInt(br.readLine());	// 테케 입력
			int result = 0;
			// ladder 입력
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(i == 99 && ladder[i][j] == 2) {	// 2인 좌표 확인, 마지막줄 입력때만 확인한다.
						currX = j;	// 마지막줄의 2를 찾아서 좌표 저장(도착지)
						currY = i;
					}
				}
			}
			
			boolean[][] visited = new boolean[100][100];	// 방문여부
			result = getStartPoint(visited, currX, currY);
			
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
