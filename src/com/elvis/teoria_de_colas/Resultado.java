package com.elvis.teoria_de_colas;

import javax.swing.*;
import java.awt.*;

public class Resultado extends JFrame {


    public Resultado(double clientesEnElSistema, double clientesEnLaCola,
                     double tiempoEnElSistema, double tiempoEnLaCola,
                     double probabilidadDeDesocupado, double probabilidadDeOcupado,
                     String unidad){
        super("Resultado");
        setBounds(0, 0, 500, 350);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        GridLayout gl = new GridLayout(6,2,0,5);
        setLayout(gl);
        add(new JLabel(clientesEnElSistema +" clientes esperando en el sistema."));
        add(new JLabel(clientesEnLaCola + " clientes esperando en la cola."));
        add(new JLabel(tiempoEnElSistema + " " + unidad + " de espera en el sistema."));
        add(new JLabel(tiempoEnLaCola + " " + unidad + " de espera en la cola."));
        add(new JLabel(probabilidadDeDesocupado + "% de que este desocupado el sistema."));
        add(new JLabel(probabilidadDeOcupado + "% de que este ocupado el sistema."));

    }
}
