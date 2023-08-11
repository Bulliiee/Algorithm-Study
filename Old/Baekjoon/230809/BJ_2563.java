package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_2563_색종이_이항우.java
 * 메모리: 14216 KB
 * 시간: 128 ms
 * 
 * 100x100 배열을 큰 도화지로 두고
 * 색종이가 10x10이기 때문에
 * 큰 도화지에 색종이의 시작 좌표부터 10x10으로 +1을 해줍니다.
 * 배열 초기화 하면 처음에 0이기 때문에 0이 아닌부분을 만나면 result를 1씩 증가시킵니다
 * 그렇게 되면 result가 색종이 붙인 크기가 됩니다.
 * 
 * @author 이항우
 *
 */
public class BJ_2563 {

	static int[][] bigPaper = new int[100][100];	// 큰 도화지
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringTokenizer st;	// 문자열 자르기용
		
		int paperNum = Integer.parseInt(br.readLine());	// 색종이 갯수 입력
		for(int rep = 0; rep < paperNum; rep++) {	// 색종이들 입력받기
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());	// 색종이 좌하단 좌표
			int col = Integer.parseInt(st.nextToken());
			
			// 입력된 좌하단 좌표에서부터 10x10으로 값을 증가시킨다.
			for(int i = row; i < row + 10; i++) {
				for(int j = col; j < col + 10; j++) {
					bigPaper[i][j]++;
				}
			}
		}
		
		// 100x100의 큰 도화지를 돌면서 0이 아닌 부분을 만나면 색종이가 있는 것이므로 결과값을 증가시킨다.
		int result = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(bigPaper[i][j] != 0) {
					result++;
				}
			}
		}
		
		// 결과 출력
		System.out.print(result);
	}
	
}
