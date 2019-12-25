package com.elvis.teoria_de_colas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventoCalcular implements ActionListener, ItemListener {
    private JTextField FieldLambda;
    private JTextField FieldMiu;
    private JTextField FieldUnidad;
    private JComboBox listaDeUnidadesDelProblema;
    private JComboBox listaDeUnidadesDelResultado;
    private JTextField fieldNumeroDeClientes;


    public EventoCalcular(JTextField FieldLambda,
                          JTextField FieldMiu,
                          JComboBox listaDeUnidadesDelProblema,
                          JComboBox listaDeUnidadesDelResultado,
                          JTextField fieldNumeroDeClientes
    ) {
        this.FieldLambda = FieldLambda;
        this.FieldMiu = FieldMiu;
        this.listaDeUnidadesDelProblema = listaDeUnidadesDelProblema;
        this.listaDeUnidadesDelResultado = listaDeUnidadesDelResultado;
        this.setFieldNumeroDeClientes(fieldNumeroDeClientes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LineaDeEspera cola = new LineaDeEspera(
                Double.parseDouble(FieldLambda.getText()),
                Double.parseDouble(FieldMiu.getText()),
                listaDeUnidadesDelResultado.getSelectedItem().toString().toLowerCase(),
                Double.parseDouble(fieldNumeroDeClientes.getText())
        );

        cola.calcularCola();
        if (!(listaDeUnidadesDelResultado.getSelectedItem().toString() == listaDeUnidadesDelProblema.getSelectedItem().toString())) {
            if (listaDeUnidadesDelResultado.getSelectedItem().toString() == listaDeUnidadesDelResultado.getItemAt(1).toString()) {
                cola.setTiempoEnElSistema((cola.getTiempoEnElSistema() / 60));
                cola.setTiempoEnLaCola((cola.getTiempoEnLaCola() / 60));
            }
            if (listaDeUnidadesDelResultado.getSelectedItem().toString() == listaDeUnidadesDelResultado.getItemAt(0).toString()) {
                cola.setTiempoEnElSistema((cola.getTiempoEnElSistema() * 60));
                cola.setTiempoEnLaCola((cola.getTiempoEnLaCola() * 60));
            }
        }

        cola.imprimirResultado();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public JTextField getFieldNumeroDeClientes() {
        return fieldNumeroDeClientes;
    }

    public void setFieldNumeroDeClientes(JTextField fieldNumeroDeClientes) {
        this.fieldNumeroDeClientes = fieldNumeroDeClientes;
    }
}
