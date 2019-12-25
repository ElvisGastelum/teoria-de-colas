package com.elvis.teoria_de_colas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class App extends JFrame {
    private JTextField fieldLambda = new JTextField(10);
    private JTextField fieldMiu = new JTextField(10);
    private JTextField fieldUnidad = new JTextField(10);
    private JButton btnCalcular = new JButton("Calcular");
    private JButton btnSalir = new JButton("Salir");
    private JComboBox listaDeUnidadesDelProblema;
    private JComboBox listaDeUnidadesDelResultado;
    private JTextField fieldNumeroDeClientes = new JTextField(10);

    public App() {
        super("Lineas de espera - by @ElvisGastelum");
        //setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icon.png")));
        setIconImage(new Image() {
            /**
             * Determines the width of the image. If the width is not yet known,
             * this method returns <code>-1</code> and the specified
             * <code>ImageObserver</code> object is notified later.
             *
             * @param observer an object waiting for the image to be loaded.
             * @return the width of this image, or <code>-1</code>
             * if the width is not yet known.
             * @see Image#getHeight
             * @see ImageObserver
             */
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            /**
             * Determines the height of the image. If the height is not yet known,
             * this method returns <code>-1</code> and the specified
             * <code>ImageObserver</code> object is notified later.
             *
             * @param observer an object waiting for the image to be loaded.
             * @return the height of this image, or <code>-1</code>
             * if the height is not yet known.
             * @see Image#getWidth
             * @see ImageObserver
             */
            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            /**
             * Gets the object that produces the pixels for the image.
             * This method is called by the image filtering classes and by
             * methods that perform image conversion and scaling.
             *
             * @return the image producer that produces the pixels
             * for this image.
             * @see ImageProducer
             */
            @Override
            public ImageProducer getSource() {
                return null;
            }

            /**
             * Creates a graphics context for drawing to an off-screen image.
             * This method can only be called for off-screen images.
             *
             * @return a graphics context to draw to the off-screen image.
             * @throws UnsupportedOperationException if called for a
             *                                       non-off-screen image.
             * @see Graphics
             * @see Component#createImage(int, int)
             */
            @Override
            public Graphics getGraphics() {
                return null;
            }

            /**
             * Gets a property of this image by name.
             * <p>
             * Individual property names are defined by the various image
             * formats. If a property is not defined for a particular image, this
             * method returns the <code>UndefinedProperty</code> object.
             * <p>
             * If the properties for this image are not yet known, this method
             * returns <code>null</code>, and the <code>ImageObserver</code>
             * object is notified later.
             * <p>
             * The property name <code>"comment"</code> should be used to store
             * an optional comment which can be presented to the application as a
             * description of the image, its source, or its author.
             *
             * @param name     a property name.
             * @param observer an object waiting for this image to be loaded.
             * @return the value of the named property.
             * @throws NullPointerException if the property name is null.
             * @see ImageObserver
             * @see Image#UndefinedProperty
             */
            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addItemsToListaDeUnidadesDelProblema();
        addItemsToListaDeUnidadesDelResultado();
        // Panel de datos
        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(3,2,0,5);
        panelDatos.setLayout(gl);
        panelDatos.add(new JLabel("Ingresar λ: "));
        panelDatos.add(fieldLambda);
        panelDatos.add(new JLabel("Ingresar μ: "));
        panelDatos.add(fieldMiu);
        panelDatos.add(new JLabel("Ingresar prob. de n clientes: (Campo obligatorio*)"));
        panelDatos.add(fieldNumeroDeClientes);
        JPanel panelUnidades = new JPanel();
        panelUnidades.setLayout(new GridLayout(1, 4, 0, 5));
        panelUnidades.add(new JLabel("Ingresar unidad del problema: "));
        panelUnidades.add(getListaDeUnidadesDelProblema());
        panelUnidades.add(new JLabel("Ingresar unidad del resultado: "));
        panelUnidades.add(getListaDeUnidadesDelResultado());
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        btnCalcular.addActionListener(
                new EventoCalcular(
                        fieldLambda,
                        fieldMiu,
                        listaDeUnidadesDelProblema,
                        listaDeUnidadesDelResultado,
                        fieldNumeroDeClientes
                )
        );
        btnSalir.addActionListener(new EventoSalir());

        panelBotones.add(btnCalcular);
        panelBotones.add(btnSalir);

        Container cp = getContentPane();
        cp.add(panelUnidades, BorderLayout.NORTH);
        cp.add(panelDatos, BorderLayout.CENTER);
        cp.add(panelBotones, BorderLayout.SOUTH);
        setSize(750, 200);
    }

    private void addItemsToListaDeUnidadesDelResultado() {
        this.listaDeUnidadesDelResultado = new JComboBox();
        listaDeUnidadesDelResultado.addItem("Minutos");
        listaDeUnidadesDelResultado.addItem("Horas");
        listaDeUnidadesDelResultado.setSelectedIndex(0);
    }

    private void addItemsToListaDeUnidadesDelProblema() {
        this.listaDeUnidadesDelProblema = new JComboBox();
        getListaDeUnidadesDelProblema().addItem("Horas");
        getListaDeUnidadesDelProblema().addItem("Minutos");
        getListaDeUnidadesDelProblema().setSelectedIndex(0);
    }

    public JComboBox<String> getListaDeUnidadesDelResultado() {
        return listaDeUnidadesDelResultado;
    }

    public JComboBox getListaDeUnidadesDelProblema() {
        return listaDeUnidadesDelProblema;
    }

    public JTextField getFieldNumeroDeClientes() {
        return fieldNumeroDeClientes;
    }
}
