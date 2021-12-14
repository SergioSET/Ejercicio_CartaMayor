package myProject;

public class ModelCartaMayor {
    private Baraja cartaJugador, cartaMaquina;
    private int estado;
    private String estadoToString;
    private int[] valoresCartas;
    private int[] palosCartas;
    private String[] palosCartasString;

    public ModelCartaMayor() {
        cartaJugador = new Baraja();
        cartaMaquina = new Baraja();
        valoresCartas = new int[2];
        palosCartas = new int[2];
        palosCartasString = new String[2];
    }

    public void elegirCartas() {
        valoresCartas[0] = cartaJugador.getValorCarta();
        palosCartas[0] = cartaJugador.getPaloCarta();
        valoresCartas[1] = cartaMaquina.getValorCarta();
        palosCartas[1] = cartaMaquina.getPaloCarta();

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
    }

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
                estadoToString = "Has sacado el mismo valor de carta que la máquina, pero ella sacó un valor de palo mejor."
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

}
