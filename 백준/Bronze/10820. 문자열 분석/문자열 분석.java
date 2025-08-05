import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// while문 조건문 바꿨지만, 문제는 해결되지 않음
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String readLine;
        while ((readLine = reader.readLine()) != null) {

            char[] arr = readLine.toCharArray();
            int[] counts = new int[4]; // 소문자, 대문자, 숫자, 공백

            // 읽은 문자열의 문자종류 카운트
            for (char c : arr) {
                if (Character.isLowerCase(c)) {
                    counts[0]++;
                } else if (Character.isUpperCase(c)) {
                    counts[1]++;
                } else if (Character.isDigit(c)) {
                    counts[2]++;
                } else if (c == ' ') {
                    counts[3]++;
                }
            }

            // 출력
//                for (int i = 0; i < counts.length; i++) {
//                    System.out.print(counts[i]);
//
//                    if (i != counts.length - 1) {
//                        System.out.print(" ");
//                    }
//                }
//                System.out.println();

            for (int i = 0; i < counts.length; i++) {
                sb.append(counts[i]);

                if (i != counts.length - 1) {
                    sb.append(' ');
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
        reader.close();
    }
}