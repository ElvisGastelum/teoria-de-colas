package com.elvis.teoria_de_colas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoCalcular implements ActionListener {
    private JTextField FieldLambda;
    private JTextField FieldMiu;
    private JTextField FieldUnidad;


    public EventoCalcular(JTextField FieldLambda, JTextField FieldMiu, JTextField FieldUnidad){
        this.FieldLambda = FieldLambda;
        this.FieldMiu = FieldMiu;
        this.FieldUnidad = FieldUnidad;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LineaDeEspera cola = new LineaDeEspera(
                Double.parseDouble(FieldLambda.getText()),
                Double.parseDouble(FieldMiu.getText()),
                FieldUnidad.getText()
        );

        cola.calcularCola();
        cola.imprimirResultado();
    }
}
