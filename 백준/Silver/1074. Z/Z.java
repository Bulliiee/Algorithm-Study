import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {
	
	static int N;
	static int r, c;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(
				new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int arrSize = (int)Math.pow(2, N);
		zzz(0, 0, 0, arrSize, N);
		
		System.out.println(result);
	}
	
	static void zzz(int sr, int sc, int acc, int size, int n) {
		if(size == 1) {
			result = acc;
			return;
		}
		int half = size/2;
		if(r < sr+half && c < sc+half) {	// 좌상
			acc += (Math.pow(4, n-1) * 0);
			zzz(sr, sc, acc, half, n-1);
		}
		else if(r < sr+half && c < sc+size) {	// 우상
			acc += (Math.pow(4, n-1) * 1);
			zzz(sr, sc+half, acc, half, n-1);
		}
		else if(r < sr+size && c < sc+half) {	// 좌하
			acc += (Math.pow(4, n-1) * 2);
			zzz(sr+half, sc, acc, half, n-1);
		}
		else if(r < sr+size && c < sc+size) {	// 우하
			acc += (Math.pow(4, n-1) * 3);
			zzz(sr+half, sc+half, acc, half, n-1);
		}
	}
	
}
