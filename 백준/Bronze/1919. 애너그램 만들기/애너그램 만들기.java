import java.util.Scanner;

//두 단어가 서로 애너그램 관계에 있도록 만들기 위해서 제거해야 하는 최소 개수의 문자 수
public class Main {
    public static int solution(String str1, String str2){
        int cnt = 0;

        int[] a = new int[26]; //알파벳 개수(소문자로 통일한 상태)
        int[] b = new int[26];
        for (int i = 0; i < str1.length(); i++)
            a[str1.charAt(i) - 'a'] ++; //'a' -'a' = 0;

        for (int i = 0; i < str2.length(); i++)
            b[str2.charAt(i) - 'a'] ++;


        for (int i = 0; i < 26; i++) {
            if(a[i] != b[i])  cnt += Math.abs(a[i] - b[i]);
        }

        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        sc.close();

        System.out.println(solution(str1, str2));
    }
}