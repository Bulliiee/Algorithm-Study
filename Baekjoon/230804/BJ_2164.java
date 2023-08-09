package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BJ_2164_카드2_이항우.java
 * 메모리: 14228 KB
 * 시간: 124 ms
 * 
 * 입력에 따른 규칙을 찾는다.
 * 입력의 2배 - 입력의 2배보다 작은 2의 제곱
 * 
 * @author 이항우
 *
 */
public class BJ_2164 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 입력받기
		
		int tempM = N * 2;	// 입력의 2배
		int temp = 1;		// 2의 제곱들을 계산하기 위함
		
		while(tempM > temp) {	// 입력의 2배보다 작은 2의 제곱 구할때까지 반복
			temp = temp << 1;	// 1에서 비트 이동으로 2배씩 계속 함
		}
		
		System.out.print(tempM - (temp / 2));	// 규칙에 따라 계산값 출력
	}
	
}
