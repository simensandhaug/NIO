import java.util.*;

public class virussmitte {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int antallInnbyggere = s.nextInt();
        int antallMatcher = s.nextInt();
        int inkubasjonstid = s.nextInt();
        int smittetid = s.nextInt();


        int[] smittede = new int[antallInnbyggere];
        int[] inkubasjon = new int[antallInnbyggere];
        int[] immune = new int[antallInnbyggere];
        int[] sykFra = new int[antallInnbyggere];
        int[] sykTil = new int[antallInnbyggere];

        int biggest = 0;
        int forrigeDag = 0;
        int deltaDag = 0;
        int sisteDag = 0;

        inkubasjon[0] = inkubasjonstid;
        sykFra[0] = inkubasjonstid;
        sykTil[0] = inkubasjonstid + smittetid;

        for(int i = 0; i < antallMatcher; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int dag = s.nextInt();

            deltaDag = dag - forrigeDag;

            for(int p = forrigeDag; p < dag; p++) {
                //for alle innbyggere
                //hvis smittede[innbygger] > 0 smittede[innbygger]-= deltaDag;
                //hvis smittede[innbygger] == 0;
                //immune[innbygger] = 1;
                //hvis inkubasjon[innbygger] > 0 inkubasjon[innbygger]-= deltaDag;
                //hvis inkubasjon[innbygger] == 0
                //smittede[innbygger] = smittetid;
                for (int k = 0; k < antallInnbyggere; k++) {
                    if (smittede[k] > 0) {
                        smittede[k] --;
                        if (smittede[k] <= 0)
                            immune[k] = 1;
                    }

                    if (inkubasjon[k] > 0) {
                        inkubasjon[k] --;
                        if (inkubasjon[k] <= 0)
                            smittede[k] = smittetid;
                    }
                }

                int antallSmittedeNow = 0;
                for(int j = 0; j < antallInnbyggere; j++) {
                    if(smittede[j] > 0) {
                        antallSmittedeNow++;
                    }
                }
                if(antallSmittedeNow > biggest){
                    biggest = antallSmittedeNow;
                }


            }

            //hvis a er smittet og b ikke er smittet og ikke immun, inkubasjon[b] = inkubasjonstid;
            //hvis b er smittet og a ikke er smittet og ikke immun, inkubasjon[a] = inkubasjonstid;
            if (smittede[a] > 0 && !(smittede[b] > 0) && immune[b] != 1 && inkubasjon[b] <= 0) {
                inkubasjon[b] = inkubasjonstid;
                sykFra[b] = dag + inkubasjonstid;
                sykTil[b] = dag + inkubasjonstid + smittetid;
            }

            if (smittede[b] > 0 && !(smittede[a] > 0) && immune[a] != 1 && inkubasjon[a] <= 0) {
                inkubasjon[a] = inkubasjonstid;
                sykFra[a] = dag + inkubasjonstid;
                sykTil[a] = dag + inkubasjonstid + smittetid;
            }

            forrigeDag = dag;

            //System.out.println("Smittet: " + smittede[1] + " Inkubasjon: " + inkubasjon[1] + " Immun: " + immune[1] + " Dag: " + dag);
            sisteDag = dag;
        }
        //finner der det er flest smittet samtidig

/*        System.out.println(sykTil[0]);
        for(int i = 0; i < sisteDag; i++) {
            int antallDagI = 0;
            for(int j = 0; j < antallInnbyggere; j++) {
                if(sykFra[j] <= i && sykTil[j] >= i) {
                    antallDagI++;
                }
            }
            biggest = Math.max(biggest, antallDagI);
        }*/
        System.out.println(biggest);
    }
}
