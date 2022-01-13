import java.util.*;

public class virussmitte {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int nrOfCitizens = s.nextInt();
        int nrOfMatches = s.nextInt();
        int incubationTime = s.nextInt();
        int sickTime = s.nextInt();

        int[] sickFrom = new int[nrOfCitizens];
        int[] sickTo = new int[nrOfCitizens];
        Meeting[] møter = new Meeting[nrOfMatches];

        int biggest = 0;
        int lastDay = 0;

        sickFrom[0] = incubationTime;
        sickTo[0] = incubationTime + sickTime;

        for(int i = 0; i < nrOfMatches; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int day = s.nextInt();

            møter[i] = new Meeting(a, b, day);
        }

        Arrays.sort(møter, (a, b) -> a.day - b.day);

        //for(int i = 0; i < møter.length; i++) {
            //System.out.println(møter[i].a + " " + møter[i].b + " " + møter[i].day);
        //}

        for(int i = 0; i < møter.length; i++) {
            Meeting m = møter[i];
            if(m.day >= sickFrom[m.a] && m.day < sickTo[m.a] && sickFrom[m.b] == 0) {
                sickFrom[m.b] = m.day + incubationTime;
                sickTo[m.b] = m.day + incubationTime + sickTime;
            }
            if(m.day >= sickFrom[m.b] && m.day < sickTo[m.b] && sickFrom[m.a] == 0) {
                sickFrom[m.a] = m.day + incubationTime;
                sickTo[m.a] = m.day + incubationTime + sickTime;
            }
        }

        lastDay = Arrays.stream(sickTo).max().getAsInt();

        int[] sickArr = new int[lastDay];

        for(int i = 0; i < nrOfCitizens; i++) {
            int from = sickFrom[i];
            int to = sickTo[i];

            for(int k = from; k < to; k++) {
                sickArr[k]++;
            }
        }

        biggest = Arrays.stream(sickArr).max().getAsInt();

        System.out.println(biggest);
        //System.out.println(Arrays.toString(sickFrom));
        //System.out.println(Arrays.toString(sickTo));
    }

    public static class Meeting {
        private int a;
        private int b;
        private int day;

        public Meeting(int a, int b, int day) {
            this.a = a;
            this.b = b;
            this.day = day;
        }
    }
}
