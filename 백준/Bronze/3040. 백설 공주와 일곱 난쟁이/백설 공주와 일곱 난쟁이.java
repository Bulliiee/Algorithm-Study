
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Main {

	static StringBuilder sb = new StringBuilder();	// 출력용 문자열
	static int[] hats = new int[9]; 	// n
	static int[] hobbits = new int[7]; 	// r

	static void searchHobbits(int cnt, int start) {

		if(cnt == 7) {	// 조합 완성 시
			int sum = 0;
			for(int temp : hobbits) {	// 결과 합을 구하고
				sum += temp;
			}
			if(sum == 100) {	// 합이 100이면 결과 합 저장
				for (int temp : hobbits) {
					sb.append(temp + "\n");
				}
			}
			return;
		}
		
		
		for(int i = start; i < 9; i++) {
			hobbits[cnt] = hats[i];
			searchHobbits(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for (int i = 0; i < 9; i++) {
			hats[i] = Integer.parseInt(br.readLine());
		}

		searchHobbits(0, 0);

		System.out.println(sb.toString());
	}

}
