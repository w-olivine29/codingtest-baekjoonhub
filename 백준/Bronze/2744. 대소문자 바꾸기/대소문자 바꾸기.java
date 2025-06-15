import java.util.Scanner;

public class Main {

    public static String change(String str){
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
           if(Character.isLowerCase(str.charAt(i))) br.append(Character.toUpperCase(str.charAt(i)));
           else br.append(Character.toLowerCase(str.charAt(i)));
        }
       return br.toString();
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        System.out.println(change(str));

    }
}