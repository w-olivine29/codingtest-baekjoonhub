import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCnt = Integer.parseInt(scanner.nextLine());

        int[][] result = new int[testCaseCnt][20];

        // 테스트 케이스 반복 수 
        for (int testIdx = 0; testIdx < testCaseCnt; testIdx++) {
            scanner.next(); // n번째 줄의 정보인 숫자는 소모시켰다.

            //mistake) 0번인덱스에 "" 가 들어간다. next() 가 공백문자 소모를 못하는 건 알고 있었지만, 문자열의 split() 에 대한 이해가 부족했었다.
            //String[] students = scanner.nextLine().split(" ");

            String[] students = scanner.nextLine().stripLeading().split(" ");
            int moveCnt = 0;

            result[testIdx][0] = Integer.parseInt(students[0]); // 한명을 뽑아 줄 맨 앞에 세우고 시작

            // 19 명의 학생들의 줄서기
            for (int i = 1; i < students.length; i++) {
                int currentStudent = Integer.parseInt(students[i]);
                int moveIdx = -1;

                // 앞에 현재 차례 학생보다 키가 큰 학생이 있는지 확인 (그 중 가장 앞 학생)
                for (int frontIdx = 0; frontIdx < i; frontIdx++) {
                    if (result[testIdx][frontIdx] > currentStudent) {
                        moveIdx = frontIdx;
                        break;
                    }
                }

                // 앞에 큰 사람이 없으면 그대로 맨 뒤에 서기
                if (moveIdx == -1) {
                    result[testIdx][i] = currentStudent;
                } else {

                    // 공간을 위해 뒤의 학생들은 한 발씩 뒤로 물러나기
                    for (int j = i; j > moveIdx; j--) {
                        result[testIdx][j] = result[testIdx][j - 1];
                        moveCnt++;
                    }
                    result[testIdx][moveIdx] = currentStudent;
                }

            }

            System.out.println((testIdx + 1) + " " + moveCnt);
        }
        
    }

}