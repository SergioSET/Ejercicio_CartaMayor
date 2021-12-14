package myProject;

import java.util.Random;

public class Baraja {
    private int valorCarta;
    private int paloCarta;

    /**
     * Method that generate a random value to carta
     *
     * @return
     */
    public int getValorCarta() {
        Random aleatorio = new Random();
        valorCarta = aleatorio.nextInt(12) + 1;
        if (valorCarta == 8 || valorCarta == 9) {
            getValorCarta();
        } else {
            return valorCarta;
        }
        return 1;
    }

    /**
     * Method that generate a random palo to a carta
     * values according to palo
     * 1 - Oros
     * 2 - Copas
     * 3 - Espadas
     * 4 - Bastos
     *
     * @return number between (1,4)
     */

    public int getPaloCarta() {
        Random aleatorio = new Random();
        paloCarta = aleatorio.nextInt(3) + 1;
        return paloCarta;
    }
}
