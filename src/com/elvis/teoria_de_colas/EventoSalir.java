package com.elvis.teoria_de_colas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoSalir implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
