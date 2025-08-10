import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> rule = Map.of("Y", 2, "F", 3, "O", 4);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        String game = input[1];

        // 한 번 같이 플레이한 사람과는 다시 플레이 x -> 중복 이름 제거
        Set<String> players = new HashSet<>();
        for (int i = 0; i < N; i++) {
            players.add(reader.readLine());
        }

        // 최대 몇번 플레이 가능한지
        // 인원수가 부족하면 게임 시작 x
        if(rule.get(game) > (players.size() + 1)){
            System.out.println(0);
        }else{
            System.out.println(players.size() / (rule.get(game) - 1));
        }


    }
}