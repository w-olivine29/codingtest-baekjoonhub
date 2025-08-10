import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 키운트 시에 해당 학생 이름을 매번 선형 검색으로 찾아서 체크하는 건 아닌 것 같고,
        // 일단 HashMap 으로 O(1) 로 검색 후 체크

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" "); //이름 저장


        // 카운팅할 때는 선형검색으로 찾으면서 카운트 하지말고, Map 으로 O(1)
        // key: 이름 , value: 카운트수 
        // 카운팅 되지 않는 학생도 있을 수 있음
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            while (token.hasMoreTokens()) {
                String name = token.nextToken();
                countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            }
        }

        // 인기카운트 순서대로 출력 (내림차순) - 정렬이 필요
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Integer count = countMap.get(names[i]);
            result.add(new Student(names[i], count != null ? count : 0));
        }

        result.sort((s1, s2) -> {

            // 인기도가 같을 경우 이름 순으로 오름차순
            if (s1.getCount() == s2.getCount()) {
                return s1.getName().compareTo(s2.getName());
            }

            return s2.getCount() - s1.getCount();
        });

        for (int i = 0; i < N; i++) {
            Student student = result.get(i);
            writer.write(student.getName() + " " + student.getCount() + "\n");
        }

        writer.close();
        reader.close();
    }
}

class Student {
    private String name;
    private int count;

    Student(String name, int count) {
        this.name = name;
        this.count = count;
    }

    int getCount() {
        return count;
    }

    String getName() {
        return name;
    }
}