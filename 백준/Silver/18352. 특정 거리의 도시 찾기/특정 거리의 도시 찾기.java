import java.io.*;
import java.util.*;


public class Main {

    static final int UND = -1; // undefined (쓰이지 않을 값으로 사용하기)

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken()); // 도시 개수
        int M = Integer.parseInt(tokens.nextToken()); // 도로의 개수
        int K = Integer.parseInt(tokens.nextToken()); // 거리 정보
        int X = Integer.parseInt(tokens.nextToken()); // 출발 도시 번호

        // 의문) 첫번째 값을 버릴거니까 1로 한다고?? 저건 내부 배열 초기 크기 설정하는건데
        //List<List<Integer>> graph = new ArrayList<>(1);

        List<List<Integer>> graph = new ArrayList<>();

        // 노드 세팅 (도시)
        graph.add(null); // 인덱싱을 1번부터 시작하기 위해, 0번은 null로 세팅
        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 세팅 (도로)
        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int arrive = Integer.parseInt(tokens.nextToken());
            graph.get(start).add(arrive);
        }

        // 방문 배열은 처음부터 모두 UND 로 초기화를 해둬야함
        List<Integer> visited = new ArrayList<>(Collections.nCopies(N + 1, UND));
        Queue<Integer> queue = new ArrayDeque<>();

        // 출발 도시 세팅하고 시작
        visited.set(X, 0);
        queue.add(X);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int nextNode : graph.get(current)) {

                // 방문을 하지 않았다면 체크 (방문할 때마다 출발도시 -> 해당 도시와의 거리값으로 세팅
                if (visited.get(nextNode) == UND) {
                    visited.set(nextNode, visited.get(current) + 1); // 이동할때마다 레벨 1증가한 값으로 세팅
                    queue.add(nextNode);
                }
            }
        }

        // 레벨이 K인 지점을 뽑기
        for (int i = 0; i <= N; i++) {
            if (visited.get(i) == K) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            StringBuilder sb = new StringBuilder();

            for (int value : result) {
                sb.append(value).append("\n");
            }
            System.out.println(sb);
        }

        reader.close();
    }
}
