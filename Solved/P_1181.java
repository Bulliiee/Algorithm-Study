package Solved;
// 단어 정렬 1181
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Voca implements Comparable<Voca> {
    private String voca;

    public Voca(String voca) {
        this.voca = voca;
    }

    public String getVoca() {
        return this.voca;
    }

    @Override
    public int compareTo(Voca v) {
        int vocaLen = this.voca.length();
        int vLen = v.getVoca().length();

        if(vocaLen > vLen) {
            return 1;
        }
        else if(vocaLen < vLen) {
            return -1;
        }
        else if(vocaLen == vLen) {
            for(int i = 0; i < vocaLen; i++) {
                if(this.voca.charAt(i) > v.getVoca().charAt(i)) {
                    return 1;
                }
                else if(this.voca.charAt(i) < v.getVoca().charAt(i)) {
                    return -1;
                }
            }
        }

        // 아예 같은경우
        return 0;
    }
}

public class P_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int input = Integer.parseInt(br.readLine());
        String []voca = new String[input];
        for(int i = 0; i < input; i++) {
            voca[i] = br.readLine();
        }
        
        sb = sortVocas(voca);
        System.out.println(sb.toString());
    }

    static StringBuilder sortVocas(String []voca) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Voca> heap = new PriorityQueue<>();
        int count = voca.length;
        String temp = "1";
        
        for(int i = 0; i < count; i++) {
            heap.add(new Voca(voca[i]));
        }

        for(int i = 0; i < count; i++) {
            String temp2 = heap.poll().getVoca();
            if(temp.equals(temp2)) {
                temp = temp2;
                continue;
            }
            temp = temp2;
            sb.append(temp2 + "\n");
        }

        return sb;
    }
}
