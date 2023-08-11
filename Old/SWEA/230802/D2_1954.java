package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * D2_1954_달팽이숫자_이항우.java
 * 메모리: 18812 KB
 * 시간: 100 ms
 * 
 * direction이라는 방향을설정하는 변수를 사용해서 상하좌우 어느곳으로 갈지 결정한다.
 * 최대 인덱스를 벗어나거나 방문한 곳을 만나면 방향을 전환시키고 방향에 따라 row, col중 어느곳으로 어떻게 이동할지 정해준다.
 * 
 * @author 이항우
 *
 */
public class D2_1954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int count = Integer.parseInt(br.readLine());
			int[][] snail = new int[count][count];	// 달팽이집 만들 배열
			boolean[][] visited = new boolean[count][count];	// 방문 여부 확인 배열
			
			int max = count * count;	// 최대 반복 횟수는 입력의 제곱임(입력x입력 배열이므로)
			int repCount = 1;	// 맨 처음은 미리 채워두므로 2부터 시작
			int direction = 0;	// 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위쪽
			int curR = 0, curC = 0;		// 현재 탐색하는 row, col
			int rCtrl = 0, cCtrl = 1;	// row, col쪽으로 움직일 떄 조정
			snail[0][0] = 1;	// 맨 처음은 미리 채움
			visited[0][0] = true;
			while(repCount++ < max) {
				// 인덱스를 벗어나거나 방문한곳을 만나면 방향 전환
				if(curR + rCtrl < 0 || curR + rCtrl >= count || 
					curC + cCtrl < 0 || curC + cCtrl >= count ||
					visited[curR + rCtrl][curC + cCtrl]) {
					direction = ++direction  % 4;	// 방향 변경
					// 방향에 따른 ctrl 설정
					if(direction == 0) {
						rCtrl = 0;
						cCtrl = 1;
					} else if(direction == 1) {
						rCtrl = 1;
						cCtrl = 0;
					} else if(direction == 2) {
						rCtrl = 0;
						cCtrl = -1;
					} else if(direction == 3) {
						rCtrl = -1;
						cCtrl = 0;
					}
				}
				curR += rCtrl;	// 현재 r과 c를 결정하고
				curC += cCtrl;
				snail[curR ][curC] = repCount;	// 숫자를 넣고
				visited[curR][curC] = true;	// 방문처리
			}
			
			// 아래는 출력
			sb.append("#").append(tc).append("\n");
			for(int i = 0; i < count; i++) {
				for(int j = 0; j < count; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
