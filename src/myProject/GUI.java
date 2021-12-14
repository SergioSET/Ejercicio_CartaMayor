package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 *
 * @version v.1.0.0 date:14/12/2021
 * @autor Sergio Escudero Tabares sergio.escudero@correounivalle.edu.co -202040801
 * Natalia Marin Hernandez natalia.andrea.marin@correounivalle.edu.co -202041622
 */
public class GUI extends JFrame {
    public static final String MENSAJE_INICIO = "Bienvenido al juego de Carta Mayor"
            + "\n Oprime el botón lanzar para iniciar el juego"
            + "\n Si sacas una carta de mayor valor que la máquina, ganarás"
            + "\n Si la carta de la máquina es de mayor valor que la tuya, perderás"
            + "\n En caso de tener el mismo valor, la victoria se determinará por el palo de la carta";

    private Header headerProject;
    private JLabel barajaJugador, barajaMaquina;
    private JButton lanzar;
    private JPanel panelCartas, panelResultados;
    private ImageIcon imagenBaraja;
    private JTextArea resultadosJuego;
    private Escucha escucha;
    private ModelCartaMayor modelCartaMayor;

    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("Juego Carta Mayor");
        //this.setSize(200, 100);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        modelCartaMayor = new ModelCartaMayor();
        //Set up JComponents
        headerProject = new Header("Juego Carta Mayor", Color.BLACK);
        this.add(headerProject, BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout



    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}