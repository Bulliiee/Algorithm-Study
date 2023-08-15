import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int size, paper[][];			// 입력받을 종이 크기와 종이 배열
	static int[] result = new int[2];	// 0: 흰색, 1: 파란색
	
	// 종이 자르기
	static void paperCut(int startR, int startC, int currSize) {
		int sum = 0;
		for(int i = startR; i < startR + currSize; i++) {	// 해당 구간의 모든 칸을 검사한다.
			for(int j = startC; j < startC + currSize; j++) {
				sum += paper[i][j];	// 해당 구간의 모든 합을 구함
			}
		}
		
		if(sum == 0) {	// 합이 0이라면 그 구간 안에는 하얀색밖에 없는것.
			result[0]++;
		} 
		else if(sum == currSize*currSize) {	// 합이 구간의 가로*세로와 같다면 모두 파란종이임.
			result[1]++;
		}
		else {
			int half = currSize/2;		// 다음에 해당하는 구역의 가로 세로는 현재 가로세로의 절반이 된다.
			paperCut(startR, startC, half);				// 좌상
			paperCut(startR, startC+half, half);		// 우상
			paperCut(startR+half, startC, half);		// 좌하
			paperCut(startR+half, startC+half, half);	// 우하
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		paper = new int[size][size];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 시작 위치는 0, 0이며, 가로 세로로 검사할 구간 크기는 입력받은 size이다.
		paperCut(0, 0, size);
		
		sb.append(result[0] + "\n" + result[1]);
		System.out.print(sb.toString());
	}
	
}