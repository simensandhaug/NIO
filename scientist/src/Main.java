import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(); //Lengden av arrayet, antall typer ressurser
        long[] r = new long[N]; //Lager ressurs arrayet
        for(int i = 0; i < N; i++) r[i] = s.nextLong(); //Legger til alle typene ressurser til arrayet
        Arrays.sort(r); //Sorterer så man kan finne de 2 største
        long biggest = r[N - 1]; // Største verdien
        long secondBiggest = r[N - 2]; //Nest største
        long sumRest = 0; //Deklarerer summen av resten
        for(int i = 0; i < N - 2; i++) sumRest += r[i]; //Finner summen av resten
        //Hvis den største og nest største verdien er mindre enn summen av resten, skriver ut floor(summen av ALT / 3)
        if(sumRest > biggest && sumRest > secondBiggest) System.out.println((int)((sumRest + biggest + secondBiggest) / 3));
        //Hvis den største og nest største verdien er større enn summen av resten, skriver ut summen av resten
        else if(biggest > sumRest && secondBiggest > sumRest) System.out.println(sumRest);
        //Ellers
        else System.out.println((int)(sumRest + secondBiggest) / 2);
    }
}
