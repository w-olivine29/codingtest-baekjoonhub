
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int N, M, K;
        
        N = Integer.parseInt(input[0]); // 수강 과목 수
        M = Integer.parseInt(input[1]); // 요구 과목 수
        K = Integer.parseInt(input[2]); // 공개한 과목 수
        
        int totalScore = 0;
        List<Grade> grades = new ArrayList<>();
        
        // 모든 과목 입력받기
        for (int i = 0; i < N; i++) {
            String[] grade = reader.readLine().split(" ");
            String subject = grade[0];
            int score = Integer.parseInt(grade[1]);
            totalScore += score;
            grades.add(new Grade(subject, score));
        }
        
        // 공개 과목들을 Set으로 저장
        Set<String> openSubjects = new HashSet<>();
        for (int i = 0; i < K; i++) {
            openSubjects.add(reader.readLine());
        }
        
        // 공개 과목이 아닌 과목들만 필터링
        List<Grade> remainingGrades = new ArrayList<>();
        int openScore = 0;
        
        for (Grade grade : grades) {
            if (openSubjects.contains(grade.subject)) {
                openScore += grade.score; // 공개 과목 점수 누적
            } else {
                remainingGrades.add(grade); // 남은 과목들
            }
        }
        
        // 남은 과목들을 점수 기준으로 정렬
        remainingGrades.sort((g1, g2) -> g1.score - g2.score);
        
        // 최소점수: 가장 낮은 (M-K)개 선택
        int remainMin = 0;
        for (int i = 0; i < (M - K); i++) {
            remainMin += remainingGrades.get(i).score;
        }
        
        // 최대점수: 가장 높은 (M-K)개 선택
        int remainMax = 0;
        int startIdx = remainingGrades.size() - (M - K);
        for (int i = startIdx; i < remainingGrades.size(); i++) {
            remainMax += remainingGrades.get(i).score;
        }
        
        System.out.printf("%d %d", (openScore + remainMin), (openScore + remainMax));
    }
    
    static class Grade {
        String subject;
        int score;
        
        public Grade(String subject, int score) {
            this.subject = subject;
            this.score = score;
        }
    }
}
