import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 미로에서 시작지점으로부터 도착지까지 몇의 거리만큼 가야하는지를 묻는 문제이다.
 * 미로와 같은 크기의 distance 배열을 만들어서 갈 수 있는 각 칸마다 시작지점으로부터 최단거리로 몇 칸 떨어져있는지 확인한다.
 * bfs를 활용하여 distance를 채워나간다.
 * 
 *
 */

// 좌표 저장할 클래스
class Points {
	int r;	// 현재 좌표의 row
	int c;	// 현재 좌표의 column
	
	public Points(int r, int c) {	// 생성자
		this.r = r;
		this.c = c;
	}
	
	// 객체가 가진 좌표가 미로의 bound 내에 있는지 확인하는 메서드
	boolean isPointOnBound(int rowSize, int colSize) {
		if( (0 <= r && r < rowSize) && (0 <= c && c < colSize) )  {
			return true;
		}
		
		return false;
	}
}

public class Main {
	static int rowSize, colSize;	// 미로 크기
	static int[][] maze;			// 미로 배열
	static int[][] distance;		// 미로 각 칸별 거리 저장 배열
	static boolean[][] visited;		// 방문 여부 배열
	
	
	// bfs 활용한 미로찾기
	static void searchMaze(Points startPoint) {
		Queue<Points> queue = new LinkedList<Points>();	// bfs에 사용할 큐
		
		// 상하좌우로 좌표 1씩 증가시키며 확인하기 위함, 각각 row, col에 더하면 된다.
		int[] rowMove = {-1, 1, 0, 0};	// 상하 이동용
		int[] colMove = {0, 0, -1, 1};	// 좌우 이동용
		
		visited[startPoint.r][startPoint.c] = true;	// bfs는 반드시 먼저 방문 여부를 체크하고 반복문에 들어가야 한다.
		queue.offer(startPoint);	// 큐에 시작점 넣기
		
		while(!queue.isEmpty()) {	// 큐에 원소가 있는동안 반복
			Points currentPoint = queue.poll();	// 현재 좌표로부터 주변 사방을 확인해야하므로 큐에서 꺼냄
			
			for(int i = 0; i < 4; i++) {	// 상하좌우 확인 위한 반복문
				int nextR = currentPoint.r + rowMove[i];		// 다음에 탐색할 좌표 구하기
				int nextC = currentPoint.c + colMove[i];
				Points nextPoint = new Points(nextR, nextC);	// 다음에 탐색할 좌표 객체 생성
				
				// 만약 현재 좌표 사방의 좌표가 미로 배열 bound 안에 있고(bound 체크 먼저 해야 인덱스 에러 안남)
				if(nextPoint.isPointOnBound(rowSize, colSize)) {	
					// 방문하지 않았으며, 1인 경우(갈 수 있는 길인 경우)에는
					if(!visited[nextPoint.r][nextPoint.c] && maze[nextPoint.r][nextPoint.c] == 1) { 
						visited[nextPoint.r][nextPoint.c] = true;	// 방문 체크를 하고
						queue.offer(nextPoint);	// 다음에 탐색할 좌표이기 때문에 큐에 넣고
						// 이전 좌표 대비 다음 좌표까지 가는 거리가 1 늘어났으니 이를 넣어준다.
						distance[nextPoint.r][nextPoint.c] = distance[currentPoint.r][currentPoint.c] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringTokenizer st = new StringTokenizer(br.readLine());	// row, col 입력받아서 자르기용
		
		rowSize = Integer.parseInt(st.nextToken());	// row set
		colSize = Integer.parseInt(st.nextToken());	// col set
		
		maze = new int[rowSize][colSize];			// 미로 배열 만들기
		distance = new int[rowSize][colSize];		// 거리 배열 만들기
		visited = new boolean[rowSize][colSize];	// 방문 여부 배열 만들기
		
		for(int row = 0; row < rowSize; row++) {
			String inputLine = br.readLine();	// 한 줄 입력받고(가로줄)
			for(int col = 0; col < colSize; col++) {
				maze[row][col] = inputLine.charAt(col) - '0';	// char값에서 '0'을 빼서 숫자가 들어가도록 한다.
			}
		}
		
		distance[0][0] = 1;	// 칸을 셀 때는 시작위치도 포함이므로 1
		
		searchMaze(new Points(0, 0));	// 0, 0에서 시작이므로 해당 객체를 파라미터로 넘겨줌
		
		System.out.print(distance[rowSize - 1][colSize - 1]);	// 목적지(가장 오른쪽 아래)에 저장된 거리 출력
	}

}