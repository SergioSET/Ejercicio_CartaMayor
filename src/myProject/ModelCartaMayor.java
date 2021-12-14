package myProject;

public class ModelCartaMayor {
    private Baraja barajaJugador, barajaMaquina;
    private int estado;
    private String estadoToString;
    private int[] valoresCartas;
    private int[] palosCartas;
    private String[] palosCartasString;

    public ModelCartaMayor() {
        barajaJugador = new Baraja();
        barajaMaquina = new Baraja();
        valoresCartas = new int[2];
        palosCartas = new int[2];

    }

    public void elegirCartas() {
        valoresCartas[0] = barajaJugador.getValorCarta();
        valoresCartas[1] = barajaMaquina.getValorCarta();
        palosCartas[0] = barajaJugador.getValorCarta();
        palosCartas[1] = barajaMaquina.getValorCarta();

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
        if (barajaJugador.getValorCarta() > barajaMaquina.getValorCarta()) {
            estado = 1;
        } else if (barajaMaquina.getValorCarta() > barajaJugador.getValorCarta()) {
            estado = 2;
        } else if (barajaMaquina.getValorCarta() == barajaJugador.getValorCarta()) {
            if (barajaJugador.getPaloCarta() < barajaMaquina.getPaloCarta()) {
                estado = 3;
            } else if (barajaMaquina.getPaloCarta() < barajaJugador.getPaloCarta()) {
                estado = 4;
            } else {
                estado = 5;
            }
        }
    }

    public String getEstadoToString() {
        switch (estado) {
            case 1:
                estadoToString = "Has sacado una carta con un valor mayor a la carta de la máquina"
                        + "\n ¡Has ganado!";
                break;
            case 2:
                estadoToString = "Has sacado una carta con un valor menor a la carta de la máquina"
                        + "\n ¡Has pérdido!";
                break;
            case 3:
                estadoToString = "Has sacado el mismo valor de carta que la máquina, pero tú sacaste un valor de palo mejor."
                        + "\n ¡Has ganado!";
                break;
            case 4:
                estadoToString = "Has sacado el mismo valor de carta que la máquina, pero ella sacó un valor de palo mejor."
                        + "\n ¡Has pérdido!";
                break;
            case 5:
                estadoToString = "Has sacado el mismo valor y palo de carta que la máquina."
                        + "\n ¡Has quedado en empate!";
                break;

            default:
                break;

        }
        return estadoToString;
    }

    public int[] getValoresCartas() {
        return valoresCartas;
    }

    public String[] getPalosCartas() {
        return palosCartasString;
    }

}
