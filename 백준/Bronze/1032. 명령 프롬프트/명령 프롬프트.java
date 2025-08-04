import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        String[] files = new String[N];
        for (int i = 0; i < N; i++) {
            files[i] = reader.readLine();
        }

        int fileNameLength = files[0].length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileNameLength; i++) {

            char c = files[0].charAt(i);
            for (int j = 1; j < files.length; j++) {
                if(c != files[j].charAt(i)){
                    c = '?';
                    break;
                }
            }
            sb.append(c);
        }

        writer.write(sb.toString());

        reader.close();
        writer.close();
    }
}
