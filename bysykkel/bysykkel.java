import java.util.Arrays;
import java.util.Scanner;

public class bysykkel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        System.out.println(N);

        int[][] heightArray = new int[N][N];
        char[][] stateArray = new char[N][N];

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                heightArray[y][x] = s.nextInt();
            }
        }

        s.nextLine();

        for(int y = 0; y < N; y++) {
            char[] row = s.nextLine().toCharArray();
            System.out.println(Arrays.toString(row));
            for(int x = 0; x < N; x++) {
                stateArray[y][x] = row[x];
            }
        }

        System.out.println(Arrays.deepToString(stateArray));

    }
    private class Node {
        private int x;
        private int y;
        private int h;
        private char state;

        public Node(int x, int y, int h, char state) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.state = state;
        }
    }
}
