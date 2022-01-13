import java.util.Arrays;
import java.util.Scanner;

public class datavirus {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // 2 <= N <= 100 000
        int m = s.nextInt(); // 1 <= M <= 200 000

        Connection[] connections = new Connection[m];

        for(int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            // 0 <= A, B < N
            connections[i] = new Connection(a, b);
        }

        System.out.println(Arrays.toString(connections));

    }

    public static class Connection {
        private int a;
        private int b;

        public Connection(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
