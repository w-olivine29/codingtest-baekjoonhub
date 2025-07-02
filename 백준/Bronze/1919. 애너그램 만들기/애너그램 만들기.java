import java.util.Scanner;

public class Main {

    static final int ALPHABET_CNT = ('z' - 'a') + 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        int[] counts1 = getAlphabetCnts(word1);
        int[] counts2 = getAlphabetCnts(word2);

        System.out.println(getRemoveCnt(counts1, counts2));
    }

    private static int[] getAlphabetCnts(String word) {
        int[] counts = new int[ALPHABET_CNT];

        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }
        return counts;
    }

    private static int getRemoveCnt(int[] counts1, int[] counts2) {
        int totalCnt = 0;

        for (int i = 0; i < ALPHABET_CNT; i++) {
            totalCnt += Math.abs(counts1[i] - counts2[i]);
        }

        return totalCnt;
    }
}