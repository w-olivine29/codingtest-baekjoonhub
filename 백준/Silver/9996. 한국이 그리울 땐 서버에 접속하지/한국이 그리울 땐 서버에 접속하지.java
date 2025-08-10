import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 패턴은 알파벳 소문자 여러 개와 별표(*) 하나
        // 별표는 빈 문자열로 바꿀 수도 있다
        // 별표는 문자열의 시작과 끝에 있지 않다.

        // 제출 실패 후 다시 찾은 조건:  문자열의 최소길이는 나와있지 않음 -> 길이에 대한 조건도 필요
        // 반례 예) abc*cd -> abcd 가 통과해서는 안됨

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] pattern = reader.readLine().split("\\*"); //정규식을 받기 때문에, *는 특수문자로, 이스케이프 문자 처리 필요

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();

            // 길이 조건 추가
            if(str.length() < pattern[0].length() + pattern[1].length()){
                System.out.println("NE");

            // 첫글자가 abc 로 시작해야함 (중간에 위치한 것을 찾으면 안됨)
            }else if(!str.startsWith(pattern[0])){ // 처음에  int indexOf(pattern[0], 0, 1) 으로 했었으나 제출 시 컴파일 에러 (해당 오버로딩 메서드는 버전 21++)
                System.out.println("NE");

            // abc*cd -> abcd 가 통과해서는 안됨 -> 시작 패턴에 속하는 것은 검사에서 제외
            }else if(!str.substring(str.indexOf(pattern[0]) + pattern[0].length()).endsWith(pattern[1])){
                System.out.println("NE");

            }else {
                System.out.println("DA");
            }

        }

        reader.close();
    }
}