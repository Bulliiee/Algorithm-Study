package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BJ_2023_신기한소수_이항우.java
 * 메모리: 15700 KB
 * 시간: 148 ms
 * 
 * 왼쪽부터 한자리, 두자리, ... 가 소수여야 하므로
 * 한자리 소수를 먼저 정해놓고
 * 그 한자리 소수 뒤에 숫자를 붙여서 소수를 판별하는 과정을 반복한다
 * 첫째자리 소수는 2, 3, 5, 7이 올 수 있고
 * 둘째자리부터는 1, 3, 7, 9가 올 수 있다.
 * 
 * @author 이항우
 *
 */
public class BJ_2023 {

	static LinkedList<Integer> result = new LinkedList<Integer>();
	static int N, primeNum[];
	
	// 소수인지 판별
	static boolean isPrime(int num) {
		int max = (int)Math.sqrt(num);
		for(int i = 2; i < max; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// 숫자 두 개를 받으면 합쳐서 리턴
	static int makeNumber(int num1, int num2) {
		return ((num1 * 10) + num2);
	}
	
	static void goodPrime() {
		Queue<Integer> queue = new LinkedList<Integer>();	// 이 큐는 소수만 들어간다
		int[] prime = { 1, 3, 7, 9 };	// 두번 째 자리부터 나올 수 있는 수
		
		// 처음에 나올 수 있는 수 큐에 넣어놓기
		queue.offer(2);
		queue.offer(3);
		queue.offer(5);
		queue.offer(7);
		
		if(N == 1) {
			while(!queue.isEmpty()) {
				result.add(queue.poll());
			}
		} else {
			while(!queue.isEmpty()) {
				int currPrimeNum = queue.poll();	// 큐에서 소수 꺼내서
				for(int i = 0; i < prime.length; i++) {
					// 큐에서 꺼낸 소수와 2째자리부터 들어올 수 있는 수를 조합한다.
					int currChkNum = makeNumber(currPrimeNum, prime[i]);
					// 그 수가 소수라면 큐에 다시 넣고 반복하면 큐에 최종적으로 신기한 소수만 들어간다
					if(isPrime(currChkNum)) {
						// 만약 이 소수의 길이가 4인 경우 결과 ArrayList에 추가한다.
						if (Integer.toString(currChkNum).length() == N) {
							result.add(currChkNum);
						}
						// 이 소수를 큐에 넣는다
						queue.offer(currChkNum);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		primeNum = new int[N];
		
		goodPrime();
		
		StringBuilder sb = new StringBuilder();
		for(int a : result) {
			sb.append(a + "\n");
		}
		System.out.println(sb.toString());
	}

}
