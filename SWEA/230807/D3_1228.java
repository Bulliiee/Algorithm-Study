package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * D3_1228_SW문제해결기본8일차_암호문1_이항우.java
 * 메모리: 18492 KB
 * 시간: 111 ms
 * 
 * 문제에 주어진대로 만들어서 출력하면 된다.
 * 링크드리스트를 사용하면 원하는 인덱스에 편하게 넣을 수 있다.
 * 
 * @author 이항우
 *
 */
public class D3_1228 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = 0;
		while(tc++ < 10) {
			int srcLen = Integer.parseInt(br.readLine());	// 원본 암호문 길이: 입력
			LinkedList<Integer> src = new LinkedList<>();	// 원본 암호문 담을 링크드리스트
			st = new StringTokenizer(br.readLine());		// 원본 암호문: 입력
			for(int i = 0; i < srcLen; i++) {
				src.add(Integer.parseInt(st.nextToken()));	// 원본 암호문 저장
			}
			
			int commandNum = Integer.parseInt(br.readLine());	// 명령어 갯수: 입력
			st = new StringTokenizer(br.readLine());		// 명령어: 입력
			while(st.hasMoreTokens()) {		// 명령어가 끝날 때까지 반복
				try {
					int input = Integer.parseInt(st.nextToken());	// 명령어 입력받은거 확인
				} catch(Exception e) {	// 입력된게 char인 경우(I입력)
					int position = Integer.parseInt(st.nextToken());	// 끼워넣을 위치
					int amount = Integer.parseInt(st.nextToken()); 		// 끼워넣을 숫자 갯수
					// 돌면서 알맞은 위치에 넣어준다.
					for (int i = 0; i < amount; i++) {
						src.add(position + i, Integer.parseInt(st.nextToken()));
					}
					
				}
			}
			
			// 출력
			sb.append("#" + tc + " ");
			for(int i = 0; i < 10; i++) {
				sb.append(src.get(i) + " ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
}
