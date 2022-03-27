package Solved;
// 나이순 정렬 10814
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Member implements Comparable<Member> {
    private int num;    // 가입한 순서
    private int age;
    private String name;

    public Member(int num, int age, String name) {
        this.num = num;
        this.age = age;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Member m) {
        if(this.age > m.getAge()) {
            return 1;
        }
        else if(this.age < m.getAge()) {
            return -1;
        }
        else if(this.age == m.getAge()) {
            if(this.num > m.getNum()) {
                return 1;
            }
            else if(this.num < m.getNum()) {
                return -1;
            }
        }

        return 0;
    }
}

public class P_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        Member []member = new Member[input];
        StringTokenizer st;
        for(int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            member[i] = new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }

        PriorityQueue<Member> heap = new PriorityQueue<>();
        for(int i = 0; i < input; i++) {
            heap.add(member[i]);
        }

        for(int i = 0; i < input; i++) {
            Member temp = heap.poll();
            sb.append(temp.getAge() + " " + temp.getName() + "\n");
        }

        System.out.println(sb.toString());
    }    
}
