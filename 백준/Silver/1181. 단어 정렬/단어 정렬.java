import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 정렬이 되어야하고, 중복단어 제거 조건 -> TreeSet을 고려하게되었음
        TreeSet<String> treeSet = new TreeSet<>((a, b) -> {
            if (a.length() < b.length()) {
                return -1;
            } else if (a.length() > b.length()) {
                return 1;
            } else { // 길이가 같으면 사전순 정렬
                return a.compareTo(b);
            }
        });

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            treeSet.add(reader.readLine());
        }

        for (String str : treeSet) {
            writer.write(str + "\n");
        }

        reader.close();
        writer.close();
    }
}
