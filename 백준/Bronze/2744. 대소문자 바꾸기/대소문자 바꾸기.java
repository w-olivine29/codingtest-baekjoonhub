import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(invertCase(string));

    }

    // Character 유틸 클래스 활용
    public static String invertCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
            }else {
                c = Character.toUpperCase(c);
            }
            sb.append(c);
        }

        return sb.toString();
    }
}