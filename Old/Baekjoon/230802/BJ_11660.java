package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BJ_11660_구간합구하기5_이항우.java 
 * 메모리:130880 KB 
 * 시간:1044 ms
 * 
 * 테이블의 입력에 대해 행별로 누적 합을 구해놓고, 구한 누적합 테이블에서 열별로도 누적합을 구한다.
 * 이후 이 누적합 테이블을 활용해 정해진 구간을 어떻게 구할지 식을 짜본다.
 * 기본적으로는 누적합 테이블의 한 지점이 (1,1: 첫 시작지점)부터 해당 지점까지 사각형으로 누적합이 되기 때문에, 
 * 기존 테이블 원하는 구간의 왼쪽열과 위쪽행을 빼고 중복또한 빼주면 된다.
 * 예를 들어 4x4 테이블에서 (2,2) ~ (3,4)까지를 구한다고 했을 때, 아래와 같다.(start와 end의 0: 행, 1: 열)
 * 	  누적합	원하는 우하단 좌표    -	원하는 왼쪽열 좌하단 좌표    -	원하는 위쪽행 우상단 좌표    - 	중복구간
 * 누적합 테이블 (3, 4) 		 -	(3, 2-1)		  -	(2-1, 3)		  -	(2-1, 2-1)
 *  식으로 표현	(end0,end1)	 -	(end0,start1-1)	  -	(start0-1,end1)	  -	(start0-1,start1-1)
 * 			o o o o			o x x x				o o o o				o x x x
 * 			o o o o			o x x x				x x x x				x x x x
 * 			o o o o			o x x x				x x x x				x x x x
 * 			x x x x			x x x x				x x x x				x x x x
 * 
 * @author 이항우
 *
 */
public class BJ_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());	// 표의 크기
		int rep = Integer.parseInt(st.nextToken());		// 합 구할 횟수
		
		int[][] table = new int[size + 1][size + 1];	// 0 사용x
		
		for(int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= size; j++) {
				// 0행, 열 사용 안해서 -1해도 상관x
				table[i][j] = table[i][j-1] + Integer.parseInt(st.nextToken());
			}
			for(int j = 1; j <= size; j++) {
				// 0행, 열 사용 안해서 -1해도 상관x
				table[i][j] += table[i-1][j];
			}
		}
		
		int []s = new int[2];		// (x1, y1)
		int []e = new int[2];		// (x2, y2)
		for(int i = 0; i < rep; i++) {
			st = new StringTokenizer(br.readLine());	// 좌표 입력
			s[0] = Integer.parseInt(st.nextToken());
			s[1] = Integer.parseInt(st.nextToken());
			e[0] = Integer.parseInt(st.nextToken());
			e[1] = Integer.parseInt(st.nextToken());
			
			// 구간 좌표
			int[] temp = new int[4];
			temp[0] = table[e[0]][e[1]];
			temp[1] = table[e[0]][s[1] - 1];
			temp[2] = table[s[0] - 1][e[1]];
			temp[3] = table[s[0] - 1][s[1] - 1];
			
			// 위에서 만든 식에 따라 출력 문자열 만들기
			sb.append((temp[0] - temp[1] - temp[2] + temp[3]) + "\n");
		}
		
		// 출력
		System.out.println(sb.toString());
	}
}
