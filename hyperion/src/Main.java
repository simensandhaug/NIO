import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int X = s.nextInt();
        int Y = s.nextInt();
        s.nextLine();

        char map[][] = new char[Y][X];

        for (int i = 0; i < Y; i++) {
            String line = s.nextLine();
            for(int j = 0; j < X; j++) {
                map[i][j] = line.charAt(j);
            }
        }
    }
}
