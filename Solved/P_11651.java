package Solved;

// 좌표 정렬하기 2 11651
// https://bullie.tistory.com/14
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Points implements Comparable<Points> {
    private int x;
    private int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(Points p) {

        if(this.y > p.getY()) {
            return 1;
        }
        else if(this.y < p.getY()) {
            return -1;
        }
        else if(this.y == p.getY()) {
            if(this.x > p.getX()) {
                return 1;
            }
            else if(this.x < p.getX()) {
                return -1;
            }
        }

        return 0;
    }
}

public class P_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int input = Integer.parseInt(br.readLine());
        int []x = new int[input];
        int []y = new int[input];

        for(int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Points []points = sortPoints(x, y);

        for(int i = 0; i < input; i++) {
            sb.append(points[i].getX() + " " + points[i].getY() + "\n");
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    // 힙정렬 사용
    static Points []sortPoints(int []x, int []y) {
        PriorityQueue<Points> pointsHeap = new PriorityQueue<>();
        
        int count = x.length;
        Points [] points = new Points[count];

        for(int i = 0; i < count; i++) {
            pointsHeap.add(new Points(x[i], y[i]));
        }

        for(int i = 0; i < count; i++) {
            points[i] = pointsHeap.poll();
        }

        return points;
    }
}
