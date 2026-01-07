//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //metodos
    public static long combinaciones(int n, int k) {
        long resultado = 1;
        for (int i = 1; i <= k; i++) {
            resultado = resultado * (n - i + 1) / i;
        }
        return resultado;
    }


    // Función que convierte palo a índice
    public static int paloAIndice(String palo) {
        switch (palo) {
            case "H":
                return 0;
            case "D":
                return 1;
            case "C":
                return 2;
            case "S":
                return 3;
        }
        return -1;
    }
    public static void main(String[] args) {
        //Creacion de valores y barajeada
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        String[] palos = {"S", "C", "H", "D"};
        cartas[] baraja = new cartas[52];
        int k = 0;
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                baraja[k] = new cartas(valores[j],palos[i]);
                k++;
            }
        }

        int barajadas = (int)(Math.random() * 100);
        System.out.println("El mazo se barajo " + barajadas + " veces");
        for (int a = 0 ; a < barajadas ; a++){
            for (int i = 0 ; i < 52 ; i++) {
                k = (int) (Math.random() * 52);
                cartas var = baraja[k];
                baraja[k] = baraja[i];
                baraja[i] = var;
            }
        }

        //Estadistica de jugadas de poker
        long totalManos = combinaciones(52, 5);
            // Póker
        long pokerr = 13 * 12 * 4;
            // Full House
        long fullHouse = 13 * combinaciones(4, 3) * 12 * combinaciones(4, 2);
            // Color sin escalera de color
        long colorr = 4 * (combinaciones(13, 5) - 10);
            // Escalera sin color
        long escaleraa = 10 * (int)(Math.pow(4,5) - 4); // 4^5 - 4
            // Trío
        long trioo = 13 * combinaciones(4, 3) * combinaciones(12, 2) * (long)Math.pow(4, 2);
            // Doble Par
        long doblePar = combinaciones(13, 2) * (long)Math.pow(combinaciones(4, 2), 2) * 11 * 4;
            // Par simple
        long parr = 13 * combinaciones(4, 2) * combinaciones(12, 3) * (long)Math.pow(4, 3);
            // Carta alta
        long cartaAlta = totalManos - (pokerr + fullHouse + colorr + escaleraa + trioo + doblePar + parr);

        //Como el mazo se barajo no se van a repetir y van a ser aleatorias las que salen
        cartas[] mano = new cartas[5];
        for (int i = 0; i < 5; i++) {
            mano[i] = baraja[i];
        }

        System.out.println("Probabilidad de Poker: " +(100.0 * pokerr / totalManos));
        System.out.println("Probabilidad de Full House: " + (100.0 * fullHouse / totalManos));
        System.out.println("Probabilidad de Color: "+ (100.0 * colorr / totalManos));
        System.out.println("Probabilidad de Escalera: " + (100.0 * escaleraa / totalManos));
        System.out.println("Probabilidad de Trío: " + (100.0 * trioo / totalManos));
        System.out.println("Probabilidad de Doble Par: "+ (100.0 * doblePar / totalManos));
        System.out.println("Probabilidad de Par: " + (100.0 * parr / totalManos));
        System.out.println("Probabilidad de Carta Alta: " + (100.0 * cartaAlta / totalManos));

        System.out.println("Tu mano es:");
        for (int i = 0 ; i < 5 ; i++){
            System.out.print(mano[i].paraLaCadena() + " ");
        }

        //jugadas que salieron
        int[] conteoValores = new int[13];
        int[] conteoPalos = new int[4];

        for( int i = 0 ; i < 5 ; i++){
            int valorInd = valorIndice(mano[i].recibirValor());
            conteoValores[valorInd]++;

            int paloind = paloAIndice(mano[i].recibirPalo());
            conteoPalos[paloind]++;
        }

        boolean trio = false, poker = false,par = false, escalera = false;
        int pares = 0;
        for( int i = 0 ; i < 13 ; i++ ){
            if(conteoValores[i] == 4){
                poker = true;
            }if (conteoValores[i] == 3){
                trio = true;
            }if (conteoValores[i] == 2){
                par = true;
                pares++;
            }
        }

        for ( int i = 0 ; i < 8 ; i++ ){
            if (conteoValores[i] == 1
                    && conteoValores [i+1] == 1
                    && conteoValores [i+2] == 1
                    && conteoValores [i+3] == 1
                    && conteoValores [i+4] == 1){
                escalera = true;
            }
        }

        boolean color = false;
        for (int i = 0; i < 4; i++) {
            if (conteoPalos[i] == 5) color = true;
        }

        int maxInd = 0;
        for (int i = 1; i < 5; i++) {
            if (valorIndice(mano[i].recibirValor()) > valorIndice(mano[maxInd].recibirValor())) {
                maxInd = i;
            }
        }

        System.out.println(" ");
        System.out.println("Resultado");
        if(poker){
            System.out.println("FELIDIDADEES HICISTE POKER");
        }else if(par && trio){
            System.out.println("Felicidades tenes full house");
        }else if(color){
            System.out.println("Felicidades tenes color");
        }else if(escalera){
            System.out.println("Felicidades tenes escalera");
        }else if(trio){
            System.out.println("Felicidades tenes un trio");
        }else if(pares == 2){
            System.out.println("Felicidades tenes par doble");
        }else if(par){
            System.out.println("Felicidades tenes par");
        }else {
            System.out.println("La carta mas alta es " + mano[maxInd].paraLaCadena());
        }

    }


    //metodos
    private static int valorIndice(String valor) {
        switch (valor) {
            case "A": return 0;
            case "2": return 1;
            case "3": return 2;
            case "4": return 3;
            case "5": return 4;
            case "6": return 5;
            case "7": return 6;
            case "8": return 7;
            case "9": return 8;
            case "T": return 9;
            case "J": return 10;
            case "Q": return 11;
            case "K": return 12;
        }
        return -1;
    }
}