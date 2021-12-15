package myProject;

import java.util.Random;

/**
 *
 * @version v.1.0.0 date:14/12/2021
 * @autor Sergio Escudero Tabares sergio.escudero@correounivalle.edu.co -202040801
 * Natalia Marin Hernandez natalia.andrea.marin@correounivalle.edu.co -202041622
 */

public class Baraja {
    private int valorCarta;
    private int paloCarta;

    /**
     * Method that generate a random value to carta
     *
     * @return number between (1,12)
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
