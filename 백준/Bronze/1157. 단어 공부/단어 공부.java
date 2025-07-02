import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        // 알파벳 개수
        int[] alphabetCnt = new int[26];

        for (int i = 0; i < str.length(); i++) {
            // 대문자 알파벳은 65부터 시작 -> 65번 문자는 0번인덱스
            alphabetCnt[Character.toUpperCase(str.charAt(i)) - 65]++;
        }

        System.out.println(getMaxCntAlphabet(alphabetCnt));
    }


    private static String getMaxCntAlphabet(int[] alphabetCnt) {

        int maxIdx = 0;
        int maxCnt = 0;
        boolean isDuplicate = false; // 최대횟수 중복여부

        for (int i = 0; i < alphabetCnt.length; i++) {
            if(maxCnt < alphabetCnt[i]){
                isDuplicate = false; // 중복상태에서 최대횟수가 갱신됐다면 다시 false 처리
                maxCnt = alphabetCnt[i];
                maxIdx = i;
            } else if (maxCnt == alphabetCnt[i]) {
                isDuplicate = true;
            }
        }

        return isDuplicate ? "?" : String.valueOf((char)(maxIdx + 65));
        }
    }