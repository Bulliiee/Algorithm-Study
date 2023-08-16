import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int size;
	static int[][] video;
	
	static StringBuilder result = new StringBuilder();
	
	static void makeQuadTree(int sr, int sc, int currSize) {
		
		int sum = 0;
		for(int i = sr; i < sr+currSize; i++) {
			for(int j = sc; j < sc+currSize; j++) {
				sum += video[i][j];
			}
		}
		
		if(sum == 0) {
			result.append("0");
		}
		else if(sum == (currSize * currSize)) {
			result.append("1");
		}
		else {
			int half = currSize/2;
			result.append("(");
			makeQuadTree(sr, sc, half);
			makeQuadTree(sr, sc+half, half);
			makeQuadTree(sr+half, sc, half);
			makeQuadTree(sr+half, sc+half, half);
			result.append(")");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		video = new int[size][size];
		for(int i = 0; i < size; i++) {
			String ln = br.readLine();
			for(int j = 0; j < size; j++) {
				video[i][j] = ln.charAt(j) - '0';
			}
		}
		
		makeQuadTree(0, 0, size);
		
		System.out.print(result.toString());
	}
	
}
