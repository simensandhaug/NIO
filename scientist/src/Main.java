import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        long houses = 0;

        int N = s.nextInt();

        PriorityQueue<Long> priQ = new PriorityQueue<>(N);


        long[] max3 = new long[3];

        for(int i = 0; i < N; i++) priQ.add(-s.nextLong());

        while(!priQ.isEmpty()) {
            long min = Arrays.stream(max3).min().getAsLong();
            houses += min;
            for(int i = 0; i < 3; i++) {
                max3[i] -= min;
                if(max3[i] == 0 && !priQ.isEmpty()) {
                    max3[i] = -priQ.remove();
                }
            }
        }
        System.out.println(houses);
    }
}
