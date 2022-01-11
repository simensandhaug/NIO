import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class togtransport {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt() - 1;
        int t = s.nextInt();
        int k = s.nextInt();

        List<int[]> prices = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int p = s.nextInt();
            prices.add(new int[]{a, b, p});
        }
        System.out.println(maxMoney(t, n, prices));
    }

    private static int maxMoney(int t, int n, List<int[]> prices) {

        if(t == 0) return 0;

        if(n == 0) return 0;

        //if(n <= t) return sumOfPrices(prices);

        //IKKE SETT SKINNE PÅ PLASS N - 1
        List<int[]> dontPlace = prices.stream().filter(priceEntry -> !contains(n, priceEntry)).collect(Collectors.toList());
        int sumDontPlace = maxMoney(t, n - 1, dontPlace);

        //SETT SKINNE PÅ PLASS N - 1
        List<int[]> doPlace = new ArrayList<>();
        int addedSumFromPlace = 0;
        for(int[] entry: prices) {
            if(contains(n, n - 1, entry)) addedSumFromPlace += getPrice(entry);
            else {
                if(contains(n, entry)) decrementN(n, entry);
                doPlace.add(entry);
            }
        }
        int sumDoPlace = addedSumFromPlace + maxMoney(t - 1, n - 1, doPlace);
        //System.out.println(n + ", " + (n-1) + ", " + addedSumFromPlace);
        return Math.max(sumDoPlace, sumDontPlace);
    }

    private static int sumOfPrices(List<int[]> prices) {
        return prices.stream().mapToInt(priceEntry -> getPrice(priceEntry)).sum();
    }


    private static void decrementN(int n, int[] priceEntry) {
            if(priceEntry[0] == n) priceEntry[0] = n - 1;
            if(priceEntry[1] == n) priceEntry[1] = n - 1;
    }

    private static boolean contains(int n, int[] priceEntry) {
        if(n == priceEntry[0] || n == priceEntry[1]) return true;
        return false;
    }

    private static boolean contains(int a, int b, int[] priceEntry) {
        if(priceEntry[0] == a && priceEntry[1] == b || priceEntry[0] == b && priceEntry[1] == a)
            return true;
        return false;
    }

    private static int getPrice(int[] priceEntry) {
            return priceEntry[2];
    }
}
