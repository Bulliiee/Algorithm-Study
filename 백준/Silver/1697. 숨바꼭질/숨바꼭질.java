import java.io.*;
import java.util.*;

public class Main {
	
	static int catchDongSang(int currS, int currD) {
		// [0]: 현재 수빈이 좌표, [1]: 몇초 지났는지
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[100001];
		
		queue.offer(new int[] {currS, 0});
		visited[currS] = true;
		
		int result = 0;
		outer:
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
						// mul			sum			sub
			int[] calc = {(temp[0] * 2), (temp[0] + 1), (temp[0] - 1)};
			
			for(int i = 0; i < 3; i++) {
				if(calc[i] == currD) {
					result = temp[1] + 1;
					break outer;
				}
			}
			for(int i = 0; i < 3; i++) {
				if(0 <= calc[i] && calc[i] <= 100000 && !visited[calc[i]]) {
					queue.offer(new int[] {calc[i], temp[1] + 1});
					visited[calc[i]] = true;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin = Integer.parseInt(st.nextToken());
		int dongSang = Integer.parseInt(st.nextToken());
		
		if(subin == dongSang) {
			System.out.print(0);
		}
		else {
			System.out.print(catchDongSang(subin, dongSang));
		}
	}
	
}
