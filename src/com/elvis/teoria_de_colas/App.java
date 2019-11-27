package com.elvis.teoria_de_colas;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    JTextField FieldLambda = new JTextField(10);
    JTextField FieldMiu = new JTextField(10);
    JTextField FieldUnidad = new JTextField(10);
    JButton btnCalcular = new JButton("Calcular");
    JButton btnSalir = new JButton("Salir");


    public App() {
        super("Lineas de espera - by @ElvisGastelum");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Panel de datos
        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(3,2,0,5);
        panelDatos.setLayout(gl);
        panelDatos.add(new JLabel("Ingresar λ: "));
        panelDatos.add(FieldLambda);
        panelDatos.add(new JLabel("Ingresar μ: "));
        panelDatos.add(FieldMiu);
        panelDatos.add(new JLabel("Ingresar unidad: "));
        panelDatos.add(FieldUnidad);
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        btnCalcular.addActionListener(new EventoCalcular(FieldLambda, FieldMiu, FieldUnidad));
        btnSalir.addActionListener(new EventoSalir());

        panelBotones.add(btnCalcular);
        panelBotones.add(btnSalir);

        Container cp = getContentPane();
        cp.add(panelDatos, BorderLayout.CENTER);
        cp.add(panelBotones, BorderLayout.SOUTH);
        setSize(500, 180);
    }

}
