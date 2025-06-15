import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(invertCase(string));

    }

    public static String invertCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {

            String target = String.valueOf(c);
            if (c >= 97) {
                sb.append(target.toUpperCase());
            }else {
                sb.append(target.toLowerCase());
            }
        }
        return sb.toString();
    }
}