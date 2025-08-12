import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    //두 개 이상의 점을 지나면서 x축 또는 y축에 평행한 직선
    // 같은 좌표가 나와도 서로 다른 점으로 간주
    // 좌표의 절댓값은  2^31보다 작은 정수 -> int로 표현가능한 범위라는 뜻?

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] coordinate = reader.readLine().split(" ");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);

            // 같은 좌표가 나와도 다른 점으로 간주 -> 카운트 추가
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
            if(entry.getValue() >=2){
                result++;
            }
        }
        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            if(entry.getValue() >=2){
                result++;
            }
        }
        System.out.println(result);
    }
}
