import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_17406_배열돌리기4_이항우.java
 * 배열 돌리기를 하는데, 주어진 연산 조건대로 수행한다.
 * 돌리는 순서별로 배열값이 다르게 나오기 때문에 순서를 고려해서 연산한다.
 * 연산의 순서를 순열을 통해 바꿔가며 돌려서 값을 확인하고, 그 중 최소값을 찾도록 한다.
 * 
 *
 */
public class Main {

	static int N, M, K;	// 입력 배열 크기, 연산 갯수
	static int arr[][], command[][];	// 입력받은 배열, 명령어 배열
	static int min = Integer.MAX_VALUE;
	
	static int[] calcSeq;		// 정해진 연산 순서, command배열의 첫 []인덱스로 사용된다.
	static boolean[] isUsed;	// 사용 여부 확인용 배열 
	
	// 시계방향 우 하 좌 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
	// 배열을 연산 순서 정하고 돌리고 나서 원상복귀 해야하기 때문에 입력받은 배열을복사하는 메서드를 쓴다
	static int[][] copyArr(int[][] srcArr) {
		int[][] tempArr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempArr[i][j] = srcArr[i][j];
			}
		}
		
		return tempArr;
	}
	
	// 원하는 배열의 값을 구하고, min과 비교해 작은걸 갱신한다.
	static void getMin(int[][] targetArr) {
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += targetArr[i][j];
			}
			min = Integer.min(min, sum);
		}
	}
	
	static void rotateArr() {
		// 명령어 순서 짜고 해당 메서드 호출 시 항상 초기상태의 배열로 시작해야 함
		int[][] tempArr1 = copyArr(arr);
		
		for(int rep = 0; rep < K; rep++) {
			// 이전 상태 저장할거
			int[][] tempArr2 = copyArr(tempArr1);
			int r = command[calcSeq[rep]][0];
			int c = command[calcSeq[rep]][1];
			int s = command[calcSeq[rep]][2];
			
			for (int i = 1; i < s + 1; i++) {
				// r,  c를 기준으로 왼쪽위로 한줄씩 증가
				int start_x = r - i - 1;    // 나는 배열이 0부터 시작하니까 하나뺴주고
				int start_y = c - i - 1;    // 너도 마찬가지고
				int x = start_x;    // 이전값 쓸거라 일단 저장
				int y = start_y;    // 너도 마찬가지고
				int row_length = start_x + i * 2;   // start 지점부터 거리
				int cal_length = start_y + i * 2;   // //
				
				int index = 0;
				// 순회
				while (index < 4) {
					int nx = x + dx[index];
					int ny = y + dy[index];
					
					// 조건에 맞다면
					if (nx >= start_x && nx <= row_length && ny >= start_y && ny <= cal_length) {
						// 다음 배열 자리에 이전배열 자리값 넣고
						tempArr1[nx][ny] = tempArr2[x][y];
						// x, y 갱신
						x = nx;
						y = ny;
					} else { // 뭐 방향 바꿔야 하는 순간이 오면
						index++;
					}
				}
			}
		}

		// 다 돌렸으면 리턴하기 전에 배열 값을 구한다.
		getMin(tempArr1);
	}
	
	// 연산 순서 정하기(KPK)
	static void getCalcSequence(int cnt) {
		// 연산자 갯수만큼 순서 다 정해졌으면
		if(cnt == K) {
			rotateArr();	// 해당 순서로 배열 돌리기 호출
			return;
		}
		
		// KPK니까 K번 돈다
		for(int i = 0; i < K; i++) {
			if(isUsed[i]) {	// 사용한거면 밑에 실행x
				continue;
			}
			
			calcSeq[cnt] = i;	// 명령어 순서 배열에 넣고
			isUsed[i] = true;	// 사용 표시 하고
			getCalcSequence(cnt+1);	// 다음 명령어 순서에 넣을거 만들고
			isUsed[i] = false;	// 사용 해제
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	// 한 줄 입력받기
		
		N = Integer.parseInt(st.nextToken());	// 배열 크기 N
		M = Integer.parseInt(st.nextToken());	// 배열 크기 M
		K = Integer.parseInt(st.nextToken());	// 연산 갯수 K
		
		// 배열 입력받기
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 연산 순서를 정해야 하므로  입력 받을 때마다 연산하지 말고 입력을 미리 다 받는다.
		command = new int[K][3];	// [연산자 K개][r,c,s]
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0] = Integer.parseInt(st.nextToken());	// r
			command[i][1] = Integer.parseInt(st.nextToken());	// c
			command[i][2] = Integer.parseInt(st.nextToken());	// s
		}
		
		// command 2차원 배열에서 앞 인덱스가 연산의 순서가 된다.
		// 때문에 KPK를 구한다.
		calcSeq = new int[K];		// 연산 순서가 담길 배열
		isUsed = new boolean[K];	// 사용 여부 확인 배열
		getCalcSequence(0);	// 연산 순서 정하기(이 안에서 호출함)
		
		// 결과 출력
		System.out.println(min);
	}
	
}