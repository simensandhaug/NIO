import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        for(int i = 0; i < M; i++) {
            int g = s.nextInt();
            if(g < N) {
                System.out.println("FOR LITE");
            }
            else if(g > N) {
                System.out.println("FOR MYE");
            }
            else{
                System.out.println("RIKTIG");
            }
        }
    }
}