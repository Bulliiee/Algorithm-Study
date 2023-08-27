import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 먼저 조합으로 가장자리를 제외한 모든 코어들을 연결할 수 있는 경우, 1개 제외, 2개 제외, ..., 0개의 코어 배열을 만든다.
 * 해당 조합의 가장 많이 연결할 수 있는 경우부터 DFS로 상하좌우 모든 경우를 탐색한다.
 * 중간에 전선 혹은 다른 코어에 걸리면 해당 경우의 이후는 탐색하지 않게 한다.
 * 만약, 조합으로 만들어질 수 있는 길이 내에서 최소값을 찾았다면 바로 멈춘다.
 * 왜냐면, 예를 들어서 5개 코어 확인해야하는데, 5개짜리 조합으로 최소값이 갱신되었다면, 4개짜리는 볼 필요도 없는 것이다.
 * 최대한 많은 코어를 연결해야 하기 때문이다.
 */
public class Solution {

	static int N, cell[][];	// 입력받을 셀 크기와 셀 초기상태
	
	// 가장자리가 아닌 멕시노스들의 위치 저장
	static List<Core> cores;	// 체크할 코어들을 넣을 ArrayList
	static int[] combRes;		// 조합으로 만들어지는 코어들의 번호(cores의 인덱스)
	
	static int min;	// 결과 들어갈 최소값
	
	static int[] moveR = {-1, 1, 0, 0};	// 상하 제어
	static int[] moveC = {0, 0, -1, 1};	// 좌우 제어

	// 코어의 좌표 지닌 클래스
	static class Core {
		int r, c;
		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테케 수 입력
		for(int tc = 1; tc <= T; tc++) {			// 테케 수만큼 반복
			N = Integer.parseInt(br.readLine());	// 셀 크기 입력
			cell = new int[N][N];					// 셀 만들기
			cores = new ArrayList<Core>();			// 체크할 코어들 담을 ArrayList 초기화
			
			// 셀 내부 입력받기
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if(cell[i][j] == 1 ) {		// 만약, 해당 셀에 코어(1)가 있다면
						if(i != 0 && j != 0 && i != N-1 && j != N-1) {	// 가장자리가 아니라면
							cores.add(new Core(i, j));					// 해당 코어 리스트에 추가
						}
					}
				}
			}
			
			// 체크할 코어의 최대 갯수부터 하나씩 줄여가며 조합을 만든다.
			for(int chkCoreNum = cores.size(); chkCoreNum > 0; chkCoreNum--) {
				min = Integer.MAX_VALUE;		// 체크할 코어의 갯수마다 확인해야 하므로 여기서 초기화
				combRes = new int[chkCoreNum];	// 얘도 마찬가지
				makeComb(0, 0, chkCoreNum);		// 조합 생성
				
				// 연결할 수 있는 코어 갯수 최대로 설정하기 위함
				// min은 같은 갯수로 체크하는 것들 중 최소 길이를 가지고, 어차피 체크할 최대갯수부터 줄여가기 때문에  이렇게 함
				if(min != Integer.MAX_VALUE) {
					break;
				}
			}
			
			// 최대한 많은 코어에 전원을 연결해도 전원이 연결되지 않는 코어가 존재할 수 있으므로
			if(min == Integer.MAX_VALUE) {
				min = 0;
			}
			// 출력할 문자열 만들기
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
	
	// 체크할 코어 조합 만들기, chkCoreNum은 코어 갯수
	// 만들어진 조합은 체크할 코어 리스트의 인덱스로 이루어짐
	static void makeComb(int cnt, int start, int chkCoreNum) {
		if(cnt == chkCoreNum) {
			// 해당 조합으로 전선 연결 메서드 호출
			chkCores(0, chkCoreNum, 0);
			return;
		}
		
		// 조합 만들기
		for(int i = start; i < cores.size(); i++) {
			combRes[cnt] = i;
			makeComb(cnt+1, i+1, chkCoreNum);
		}
	}
	
	// cnt: 만든 조합에서 확인할 코어리스트의 인덱스, chkCoreNum: 조합 길이, totalLineCount: 연결된 전선 길이
	// 아래에서 연결되지 않은 경우는 끊기 때문에 totalLineCount는 최종적으로 전부 연결한 경우에만 갱신된다.
	static void chkCores(int cnt, int chkCoreNum, int totalLineCount) {
		// 기저조건, 모든 전선이 연결되었을 경우
		if(cnt == chkCoreNum) {
			min = Math.min(min, totalLineCount);	// 모두 연결되었을 경우 전선 길이 최소값 구하기
			return;	// 끝까지 봤으므로 리턴해서 이전으로 돌아가 다음 방향 탐색
		}
		
		// 현재 코어 위치
		int currR = cores.get(combRes[cnt]).r;	
		int currC = cores.get(combRes[cnt]).c;
		// 현재 코어 위치 기준으로 상하좌우 확인
		for(int dir = 0; dir < 4; dir++) {
			int currLineLen = 0;	// 한 방향에 대해 현재 전선의 길이
			int nextR = currR;	// 다음 위치 설정용
			int nextC = currC;
			// 전선을 연결 가능 여부 확인할 때까지 반복
			while(true) {
				// 다음 위치 설정
				nextR += moveR[dir];
				nextC += moveC[dir];
				
				// 범위 벗어나면 while탈출(다음 방향)
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
					break;
				}
				
				// 전선 1로 표시할거라서 가는 길에 다른 코어나 전선 만나면 currLineLen 0으로 바꾸고 while탈출(다음방향)
				if(cell[nextR][nextC] == 1 || cell[nextR][nextC] == -1) {
					currLineLen = 0;
					break;
				}
				
				currLineLen++;	// 위에서 안걸리면 길이+1
			}
			
			// 0이라면 연결되지 않은 것이므로 아래를 실행하지 않아야 불필요한 연산을 안한다.
			// 즉, 해당 if문 아래에 코드가 추가되지 않는다면 0일 경우 return과 같다.
			if(currLineLen != 0) {
				// currLineLne 길이만큼 전선을 연결
				fillCell(currR, currC, dir, currLineLen, -1);
				// 다음 코어 확인 위해 재귀 호출
				chkCores(cnt+1, chkCoreNum, totalLineCount + currLineLen);
				// 다음 방향도 탐색해야 하니 전선 연결한거 되돌림
				fillCell(currR, currC, dir, currLineLen, 0);
			}
		}
	}
	
	// 전선을 연결할 수 있거나 이미 표시한걸 되돌리는 경우 해당 메서드 호출
	// r, c에서부터 dir방향으로 lineLen 길이만큼 연결하거나(type -1), 연결 해제(type 0)
	static void fillCell(int r, int c, int dir, int lineLen, int type) {
		// 현재 코어 위치(r, c)에서 전선 길이(lineLen)만큼 cell 갱신
		for(int i = 0; i < lineLen; i++) {
			r += moveR[dir];
			c += moveC[dir];
			cell[r][c] = type;
		}
	}

}