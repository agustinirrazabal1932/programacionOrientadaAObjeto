package ar.edu.unlu.juego.vista.consola;


import ar.edu.unlu.juego.controlador.Controlador;
import ar.edu.unlu.juego.vista.Ivista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsolaGrafica implements Ivista {
    private final JFrame frame;
    private JPanel contentPane;
    private JTextArea txtSalidaConsola;
    private JTextField txtEntrada;
    private JButton btnEnter;
    private Controlador controlador;

    private Flujo flujoActual;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public ConsolaGrafica() {
        frame = new JFrame("EL DOS");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSalidaConsola.append(txtEntrada.getText() + "\n");
                procesarEntrada(txtEntrada.getText());
                txtEntrada.setText("");
            }
        });
    }

    private void procesarEntrada(String input) {
        input = input.trim();
        flujoActual = flujoActual.procesarEntrada(input);
        flujoActual.mostarSiguienteTexto();
    }
    
    public void println(String texto) {
        txtSalidaConsola.append(texto + "\n");
    }
    


    public void mostrar() {
        frame.setVisible(true);
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }


    @Override
    public void mostrarMenuPrincipal() {
        mostrar();
        flujoActual = new FlujoMenuInicial(this, controlador);
        flujoActual.mostarSiguienteTexto();
    }

    @Override
    public void devolverConsolaGrafica() {
        flujoActual=new FlujoEsperar(this,controlador);
        flujoActual.mostarSiguienteTexto();
    }

    @Override
    public void jugar(String id) {
        flujoActual=new FlujoJugador1(this,controlador,id,id);
        flujoActual.mostarSiguienteTexto();
    }

}
