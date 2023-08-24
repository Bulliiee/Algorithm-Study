import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int areaNum;
	static Area[] areas;
	
	static boolean[] isUsed;	// 조합으로 구역1 만들었을 때 사용한 숫자 표시용
	static int[][] partArea = new int[2][];	// 조합으로 만들어진 구역
	
	static int min = Integer.MAX_VALUE;
	
	static class Area {
		int population;
		int[] connection = null;
		public Area(int population) {
			this.population = population;
		}
		public void setConnectionArray(int[] connection) {
			this.connection = Arrays.copyOf(connection, connection.length);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		areaNum = Integer.parseInt(br.readLine());
		
		areas = new Area[areaNum+1];	// 0번사용x
		
		// 각 구역의 인구수 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= areaNum; i++) {
			areas[i] = new Area(Integer.parseInt(st.nextToken()));
		}
		
		// 각 구역에 연결된 구역번호 배열 넣기
		for(int i = 1; i <= areaNum; i++) {
			st = new StringTokenizer(br.readLine());
			int adjLen = Integer.parseInt(st.nextToken());
			int[] connection = new int[adjLen];
			for(int j = 0; j < adjLen; j++) {
				connection[j] = Integer.parseInt(st.nextToken());
			}
			areas[i].setConnectionArray(connection);
		}
		
		for(int i = 1; i <= areaNum/2; i++) {
			partArea[0] = new int[i];			// 조합으로 만들어질 구역 배열
			partArea[1] = new int[areaNum-i];	// 나머지 구역 배열
			isUsed = new boolean[areaNum+1];	// 조합으로 사용한 구역 체크
			getAreaComb(0, 1, i);
		}
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}
	
	// resSize: 만들어질 배열 조합
	static void getAreaComb(int cnt, int start, int resSize) {
		if(cnt == resSize) {
			// 조합으로 만든거 빼고 나머지 구역들 배열 만들기
			int idx = 0;
			for(int i = 1; i <= areaNum; i++) {
				if(!isUsed[i]) {
					partArea[1][idx++] = i;
				}
			}
			
			if(chkArea()) {
				int sum1 = 0;
				int sum2 = 0;
				for(int i = 0; i < partArea[0].length; i++) {
					sum1 += areas[partArea[0][i]].population;
				}
				for(int i = 0; i < partArea[1].length; i++) {
					sum2 += areas[partArea[1][i]].population;
				}
				min = Math.min(min, Math.abs(sum1-sum2));
			}
			
			return;
		}
		
		for(int i = start; i <= areaNum; i++) {
			partArea[0][cnt] = i;	// 구역은 1부터 시작함
			isUsed[i] = true;
			getAreaComb(cnt+1, i+1, resSize);
			isUsed[i] = false;
		}
	}
	
	// bfs로 확인
	static boolean chkArea() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		boolean[] visited = new boolean[areaNum+1];	// bfs시 방문여부 확인용
		
		for(int rep = 0; rep < 2; rep++) {
			int cnt = 0;
			q.offer(partArea[rep][0]);
			visited[partArea[rep][0]] = true;
			cnt++;
			while(!q.isEmpty()) {
				int currArea = q.poll();
				int[] currAreaConnection = areas[currArea].connection;
				
				for(int i = 0; i < currAreaConnection.length; i++) {
					// 연결되어있는지 확인
					for(int j = 0; j < partArea[rep].length; j++) {
						// 연결되어있으면
						if(!visited[currAreaConnection[i]] && currAreaConnection[i] == partArea[rep][j]) {
							q.offer(currAreaConnection[i]);
							visited[currAreaConnection[i]] = true;
							cnt++;
						}
					}
				}
			}

			if(cnt != partArea[rep].length) {
				return false;
			}
		}

		return true;
	}
	
}
