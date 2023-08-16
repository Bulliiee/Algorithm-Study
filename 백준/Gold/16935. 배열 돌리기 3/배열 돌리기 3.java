import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, M, R;
	
	// 상하반전
	static void func1(int[][] arr) {
		// 행단위로 바꿔버려도 된다.
		for(int i = 0; i < (N / 2); i++) {
			int[] temp = arr[i];
			arr[i] = arr[N-1-i];
			arr[N-1-i] = temp;
		}
	}
	// 좌우반전
	static void func2(int[][] arr) {
		// 각 인덱스를 돌며 좌우반전 시킨다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < (M / 2); j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M-1-j];
				arr[i][M-1-j] = temp;
			}
		}
	}
	// 오른쪽 90도
	static int[][] func3(int[][] arr) {
		// 오른쪽 열을 읽어 위 행부터 채워간다.
		N ^= M; M ^= N; N ^= M;	// N M스왑
		int[][] newArr = new int[N][M];
		
		int idxCtrl = M-1;
		for(int i = 0; i < M; i++) {
			int[] temp = arr[i];	// 기존 배열(arr)의 각 행을 뽑아서
			for(int j = 0; j < N; j++) {
				newArr[j][idxCtrl] = temp[j];	// 새로운 배열(newArr)의 오른쪽 열로 넣는다.
			}
			idxCtrl--;
		}
		
		return newArr;
	}
	// 왼쪽 90도
	static int[][] func4(int[][] arr) {
		N ^= M; M ^= N; N ^= M;	// N M스왑
		int[][] newArr = new int[N][M];
		
		for(int i = 0; i < M; i++) {
			int[] temp = arr[i];	// 기존 배열(arr)의 각 행을 뽑아서
			int idxCtrl = N-1;
			for(int j = 0; j < N; j++) {
				newArr[idxCtrl--][i] = temp[j];	// 새로운 배열(newArr)의 오른쪽 열로 넣는다.
			}
		}
		
		return newArr;
	}
	// 그룹 시계
	static void func5(int[][] arr, int[][][] arrs) {
		int nCtrl, mCtrl;
		
		// 좌상->우상
		nCtrl = 0;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = M/2;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[0][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
		// 우상->우하
		nCtrl = N/2;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = M/2;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[1][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
		// 우하->좌하
		nCtrl = N/2;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = 0;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[2][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
		// 좌하->좌상
		nCtrl = 0;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = 0;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[3][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
	}
	// 그룹 반시계
	static void func6(int[][] arr, int[][][] arrs) {
		int nCtrl, mCtrl;
		
		// 좌상->좌하
		nCtrl = N/2;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = 0;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[0][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
		// 좌하->우하
		nCtrl = N/2;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = M/2;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[3][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
		// 우하->우상
		nCtrl = 0;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = M/2;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[2][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
		// 우상->좌상
		nCtrl = 0;
		for (int i = 0; i < N / 2; i++) {
			mCtrl = 0;
			for (int j = 0; j < M / 2; j++) {
				arr[nCtrl][mCtrl] = arrs[1][i][j];
				mCtrl++;
			}
			nCtrl++;
		}
	}
	
	// 입력한 배열 4개 구역으로 쪼개고 리턴
	static int[][][] cutArr(int[][] arr) {
		int[][][] arrs = new int[4][N/2][M/2];	// 4개 구역으로 쪼개기
		
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				arrs[0][i][j] = arr[i][j];
			}
		}
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				arrs[1][i][j - M/2] = arr[i][j];
			}
		}
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				arrs[2][i - N/2][j - M/2] = arr[i][j];
			}
		}
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				arrs[3][i - N/2][j] = arr[i][j];
			}
		}
		
		return arrs;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 첫줄
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// 입력 둘째줄부터 배열
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 4개 구역으로 쪼갠 배열
		int[][][] arrs;	
		
		// 입력 셋째줄 명령어
		st = new StringTokenizer(br.readLine());
		for(int rep = 0; rep < R; rep++) {
			int command = Integer.parseInt(st.nextToken());
			
			// 명령어에 맞는거 호출
			switch(command) {
			case 1:
				func1(arr);
				break;
			case 2:
				func2(arr);
				break;
			// 여기부턴 배열 크기 바뀔 수 있으므로 배열 리턴받음
			case 3:
				arr = func3(arr);
				break;
			case 4:
				arr = func4(arr);
				break;
			// 여기까진 배열 크기 바뀔 수 있으므로 배열 리턴받음
			case 5:
				arrs = cutArr(arr);
				func5(arr, arrs);
				break;
			case 6:
				arrs = cutArr(arr);
				func6(arr, arrs);
				break;
			}
		}
		
		// 배열 StringBuilder에 넣기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		// 출력
		System.out.print(sb.toString());
	}

}
