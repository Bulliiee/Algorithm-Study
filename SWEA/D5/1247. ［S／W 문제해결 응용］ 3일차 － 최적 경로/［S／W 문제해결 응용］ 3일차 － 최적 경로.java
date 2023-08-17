import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int customerCount;
	static Points start, end;
	static Points[] customers;
	
	static boolean[] isUsed;
	static int[] customerIdx;
	static int min;
	
	static class Points {
		int r;
		int c;
		public Points(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public int getDistance(Points target) {
			return (Math.abs(this.r - target.r) + Math.abs(this.c - target.c));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테케 입력
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			// 고객 수 입력
			customerCount = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			// 회사 좌표 입력
			int tempR = Integer.parseInt(st.nextToken());
			int tempC = Integer.parseInt(st.nextToken());
			start = new Points(tempR, tempC);
			
			// 집 좌표 입력
			tempR = Integer.parseInt(st.nextToken());
			tempC = Integer.parseInt(st.nextToken());
			end = new Points(tempR, tempC);
			
			// 고객들 좌표 입력
			customers = new Points[customerCount];
			for(int i = 0; i < customerCount; i++) {
				tempR = Integer.parseInt(st.nextToken());
				tempC = Integer.parseInt(st.nextToken());
				customers[i] = new Points(tempR, tempC);
			}
			
			// 초기화
			min = Integer.MAX_VALUE;
			// 계산
			customerIdx = new int[customerCount];
			isUsed = new boolean[customerCount];
			getMinDistance(0);
			
			sb.append("#" + tc + " " + min + "\n");
		}
		
		System.out.print(sb.toString());
	}
	
	// 고객 순열 만들기(순서 상관 있으니까)
	static void getMinDistance(int cnt) {
		if(cnt == customerCount) {
			int temp = 0;
			// 회사 -> 첫번째 고객
			Points current = start;
			Points next = customers[customerIdx[0]];
			temp += current.getDistance(next);
			if(temp >= min) return;
			
			// 두번째 고객 ~ 마지막 고객
			for(int i = 1; i < customerCount; i++) {
				current = next;
				next = customers[customerIdx[i]];
				temp += current.getDistance(next);
				if(temp >= min) return;
			}
			
			// 마지막 고객 ~ 집
			temp += next.getDistance(end);
			
			min = Integer.min(temp, min);
			return;
		}
		
		for(int i = 0; i < customerCount; i++) {
			if(isUsed[i]) {
				continue;
			}
			isUsed[i] = true;
			customerIdx[cnt] = i;
			getMinDistance(cnt+1);
			isUsed[i] = false;
		}
	}
	
}
