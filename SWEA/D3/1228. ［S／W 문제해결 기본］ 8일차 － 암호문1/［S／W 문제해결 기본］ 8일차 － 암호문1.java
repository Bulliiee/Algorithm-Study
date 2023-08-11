import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 */
public class Solution {
	
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