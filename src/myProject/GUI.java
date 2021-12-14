package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 *
 * @version v.1.0.0 date:14/12/2021
 * @autor Sergio Escudero Tabares sergio.escudero@correounivalle.edu.co -202040801
 * Natalia Marin Hernandez natalia.andrea.marin@correounivalle.edu.co -202041622
 */
public class GUI extends JFrame {
    public static final String MENSAJE_INICIO = "Bienvenido al juego de Carta Mayor"
            + "\nOprime el botón lanzar para iniciar el juego"
            + "\nSi sacas una carta de mayor valor que la máquina, ganarás"
            + "\nSi la carta de la máquina es de mayor valor que la tuya, perderás"
            + "\nEn caso de tener el mismo valor, la victoria se determinará por el palo de la carta";

    private Header headerProject;
    private JLabel barajaJugador, barajaMaquina;
    private JButton lanzar;
    private JPanel panelJugador, panelResultados, panelMaquina, panelJuego;
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
        //this.setSize(450, 550);
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

        imagenBaraja = new ImageIcon(getClass().getResource("/resources/baraja.png"));

        barajaJugador = new JLabel(imagenBaraja);
        barajaMaquina = new JLabel(imagenBaraja);

        panelJugador = new JPanel();
        panelJugador.setPreferredSize(new Dimension(200, 180));
        panelJugador.setBorder(BorderFactory.createTitledBorder("Tu carta"));
        panelJugador.add(barajaJugador);

        //this.add(panelJugador, BorderLayout.WEST);

        panelMaquina = new JPanel();
        panelMaquina.setBorder(BorderFactory.createTitledBorder("Carta de máquina"));
        panelMaquina.setPreferredSize(new Dimension(200, 180));
        panelMaquina.add(barajaMaquina);

        //this.add(panelMaquina, BorderLayout.EAST);

        panelResultados = new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        panelResultados.setPreferredSize(new Dimension(450, 150));
        resultadosJuego = new JTextArea(6, 31);
        resultadosJuego.setLineWrap(true);
        resultadosJuego.setBackground(null);
        resultadosJuego.setWrapStyleWord(true);
        resultadosJuego.setEditable(false);

        resultadosJuego.setText(MENSAJE_INICIO);
        panelResultados.add(resultadosJuego);

        this.add(panelResultados, BorderLayout.SOUTH);

        lanzar = new JButton("Lanzar");
        lanzar.addActionListener(escucha);
        lanzar.setPreferredSize(new Dimension(80, 100));

        this.add(lanzar, BorderLayout.CENTER);

        panelJuego = new JPanel();
        panelJuego.setSize(getMinimumSize());
        panelJuego.add(panelJugador);
        panelJuego.add(panelMaquina);

        this.add(panelJuego, BorderLayout.NORTH);

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
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            modelCartaMayor.elegirCartas();

            int[] valoresCartas = modelCartaMayor.getValoresCartas();
            String[] palosCartasString = modelCartaMayor.getPalosCartasString();

            imagenBaraja = new ImageIcon(getClass().getResource("/resources/" + valoresCartas[0] + palosCartasString[0] + ".png"));
            barajaJugador.setIcon(imagenBaraja);

            imagenBaraja = new ImageIcon(getClass().getResource("/resources/" + valoresCartas[1] + palosCartasString[1] + ".png"));
            barajaMaquina.setIcon(imagenBaraja);

            modelCartaMayor.determinarJuego();

            panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
            resultadosJuego.setText(modelCartaMayor.getEstadoToString());
            resultadosJuego.setRows(4);
            resultadosJuego.setColumns(31);
            panelResultados.add(resultadosJuego);

            revalidate();
            repaint();
        }
    }
}
