import java.io.*;
import java.util.*;

public class Solution {
	
	static int treeNum;	// 나무 갯수
	static int[] trees;	// 나무들
	
	static int maxHeight;	// 나무들 중 가장 높은 애 높이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테케 수 입력
		int T = Integer.parseInt(br.readLine());
		// 테케 수만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			// 나무 갯수 입력
			treeNum = Integer.parseInt(br.readLine());	
			
			// 나무들 입력
			trees = new int[treeNum];
			st = new StringTokenizer(br.readLine());
			int temp;
			maxHeight = 0;
			for(int i = 0; i < treeNum; i++) {
				temp = Integer.parseInt(st.nextToken());
				trees[i] = temp;
				maxHeight = Math.max(maxHeight, temp);		// 최대값 설정
			}
			
			int odd = 0;	// 홀수
			int even = 0;	// 짝수
			// 각 나무들이 자라야 하는 높이(temp)에서 짝수날과 홀수날의 갯수를 구한다.
			for(int i = 0; i < treeNum; i++) {
				temp = (maxHeight - trees[i]);
				odd += (temp % 2);
				even += (temp / 2);
			}
			
			// 홀수날과 짝수날들의 값을 최대한 균형을 맞춰준다.
			// 짝수날 한 번은 홀수날 2번으로 보면 된다. 홀수날은 물을 1 주고 짝수날은 물을 2 주기 때문이다.
			// 즉, 짝수날이 홀수 날보다 많은 경우에는 균형을 잘 맞출 수 있지만, 홀수날이 많으면 못맞춘다.
			while(even > odd+1) {
				even--;
				odd += 2;
			}
			
			// 위에서 최대한 균등하게 맞춘 odd와 even에서 홀수날이 짝수날보다 크거나 같은 경우가 제일 좋다.
			// 왜냐면 첫째날(홀수날)부터 시작하기 때문에 위의 경우는 odd와 even을 더하기만 하면된다.
			int result = 0;
			if((odd+1 == even)) {
				result = odd + even + 1;
			}
			else if(odd > even) {
				result += (even*2);
				result += ((odd-even)*2 - 1);
			}
			else {
				result = odd + even;
			}
			
			
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.print(sb.toString());
	}
	
}
