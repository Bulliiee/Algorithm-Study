import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 */
public class Main {
	
	static int[] key = new int[9];		// n, 난쟁이 9명 키
	static int[] hobbits = new int[7];	// r, 만든 조합
	static int[] result = new int[7];	// 결과 담을 배열
	
	// nCr을 구한다. 7명을 찾았다면 true 리턴한다.
	static void getHobbits(int cnt, int start) {
		// 기저조건
		if(cnt == 7) {
			// 일곱 난쟁이의 키를 더한다.
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += hobbits[i];
			}
			if(sum == 100) {	// 난쟁이 7명 찾았을 때 바로 종료
				result = Arrays.copyOf(hobbits, 7);
			}
			return ;
		}
		
		
		// 반복
		for(int i = start; i < 9; i++) {
			hobbits[cnt] = key[i];	// 난쟁이 조합 만들기
			getHobbits(cnt+1, i+1);	// 재귀 호출
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 아홉 난쟁이의 키를 입력받는다.
		for(int i = 0; i < 9; i++) {
			key[i] = Integer.parseInt(br.readLine());
		}
		
		// 조합을 통해 키가 100인 경우를 구한다.
		getHobbits(0, 0);
		
		// 결과를 정렬한다.
		Arrays.sort(result);
		
		// 결과 출력 위한 문자열을 만든다.
		for(int temp : result) {
			sb.append(temp + "\n");
			
		}
		
		// 결과를 출력한다.
		System.out.print(sb.toString());
	}
	
}
