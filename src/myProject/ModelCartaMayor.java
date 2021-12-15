package myProject;

/**
 * This class is used for ...
 *
 * @version v.1.0.0 date:14/12/2021
 * @autor Sergio Escudero Tabares sergio.escudero@correounivalle.edu.co -202040801
 * Natalia Marin Hernandez natalia.andrea.marin@correounivalle.edu.co -202041622
 */

public class ModelCartaMayor {
    private Baraja cartaJugador, cartaMaquina;
    private int estado;
    private String estadoToString;
    private int[] valoresCartas;
    private int[] palosCartas;
    private String[] palosCartasString;
    private int flag;

    /**
     * Class Constructor
     */
    public ModelCartaMayor() {
        cartaJugador = new Baraja();
        cartaMaquina = new Baraja();
        valoresCartas = new int[2];
        palosCartas = new int[2];
        palosCartasString = new String[2];
        flag = 0;
    }

    /**
     * Method that generates the values and the suit of the cards
     */

    public void elegirCartas() {
        valoresCartas[0] = cartaJugador.getValorCarta();
        palosCartas[0] = cartaJugador.getPaloCarta();
        valoresCartas[1] = cartaMaquina.getValorCarta();
        palosCartas[1] = cartaMaquina.getPaloCarta();

        if (flag == 0) {
            flag = 1;
        } else {
            flag = 0;
        }

        switch (palosCartas[0]) {
            case 1:
                palosCartasString[0] = "o";
                break;
            case 2:
                palosCartasString[0] = "c";
                break;
            case 3:
                palosCartasString[0] = "e";
                break;
            case 4:
                palosCartasString[0] = "b";
                break;
            default:
                break;
        }

        switch (palosCartas[1]) {
            case 1:
                palosCartasString[1] = "o";
                break;
            case 2:
                palosCartasString[1] = "c";
                break;
            case 3:
                palosCartasString[1] = "e";
                break;
            case 4:
                palosCartasString[1] = "b";
                break;
            default:
                break;
        }

    }

    /**
     * Method that determines the state of the game
     */
    public void determinarJuego() {
        if (valoresCartas[0] > valoresCartas[1]) {
            estado = 1;
        } else if (valoresCartas[0] < valoresCartas[1]) {
            estado = 2;
        } else if (valoresCartas[0] == valoresCartas[1]) {
            if (palosCartas[0] < palosCartas[1]) {
                estado = 3;
            } else if (palosCartas[0] > palosCartas[1]) {
                estado = 4;
            } else {
                estado = 5;
            }
        }
        if (flag == 0) {
            flag = 1;
        } else {
            flag = 0;
        }

    }

    /**
     * Method that determines the message that will be show in the resultadosJuegos JTextArea
     */
    public String getEstadoToString() {
        switch (estado) {
            case 1:
                estadoToString = "Has sacado una carta con un valor mayor a la carta de la máquina "
                        + "\n¡Has ganado!";
                break;
            case 2:
                estadoToString = "Has sacado una carta con un valor menor a la carta de la máquina"
                        + "\n¡Has pérdido!";
                break;
            case 3:
                estadoToString = "Has sacado el mismo valor de carta que la máquina, pero tú sacaste un valor de palo mejor."
                        + "\n¡Has ganado!";
                break;
            case 4:
                estadoToString = "Has sacado el mismo valor de carta que la máquina, pero la máquina sacó un valor de palo mejor."
                        + "\n¡Has pérdido!";
                break;
            case 5:
                estadoToString = "Has sacado el mismo valor y palo de carta que la máquina."
                        + "\n¡Has quedado en empate!";
                break;

            default:
                break;

        }
        return estadoToString;
    }

    public int[] getValoresCartas() {
        return valoresCartas;
    }

    public int[] getPalosCartas() {
        return palosCartas;
    }

    public String[] getPalosCartasString() {
        return palosCartasString;
    }

    public int getFlag() {
        return flag;
    }

}
