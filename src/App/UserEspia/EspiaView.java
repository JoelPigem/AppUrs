package App.UserEspia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EspiaView {
    private JFrame frame;
    private JButton botoEnviarMissatge, botoCerrarSesion;
    private JLabel fichaUsuari, labelMissatge, labelMensajeEncriptado;
    private JTextField entradaMissatge;

    EspiaView(){
        frame = new JFrame("Espia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Crear un panel para la parte superior, donde irá el botón de cerrar sesión
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(70, 103, 144));

        botoCerrarSesion = new JButton("Cerrar Sesión");
        panelSuperior.add(botoCerrarSesion, BorderLayout.WEST); // Ubicamos el botón a la izquierda

        // Crear un panel central para centrar los elementos restantes
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(new Color(70, 103, 144));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        gbc.anchor = GridBagConstraints.CENTER;  // Centramos los componentes horizontalmente

        // Título con nombre del espía
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Hacer que el título ocupe dos columnas
        JLabel labelTitol = new JLabel("Espia", JLabel.CENTER);
        labelTitol.setForeground(Color.WHITE);
        labelTitol.setFont(new Font("Arial", Font.BOLD, 18));
        panelCentral.add(labelTitol, gbc);

        // Ficha de usuario - Etiqueta
        gbc.gridy++;
        gbc.gridwidth = 1; // Volvemos a 1 columna para el resto de componentes
        gbc.anchor = GridBagConstraints.EAST; // Alineamos la etiqueta a la derecha
        JLabel etiquetaFicha = new JLabel("Ficha Usuario:");
        etiquetaFicha.setForeground(Color.WHITE);
        panelCentral.add(etiquetaFicha, gbc);

        // Ficha de usuario - Contenido
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST; // Alineamos el contenido a la izquierda
        fichaUsuari = new JLabel();
        fichaUsuari.setPreferredSize(new Dimension(200, 30));
        fichaUsuari.setForeground(Color.WHITE);
        panelCentral.add(fichaUsuari, gbc);

        // Sección de envío de mensajes - Etiqueta
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST; // Etiqueta alineada a la derecha
        labelMissatge = new JLabel("Enviar Missatge:");
        labelMissatge.setForeground(Color.WHITE);
        panelCentral.add(labelMissatge, gbc);

        // Sección de envío de mensajes - Entrada de texto y botón en la misma fila
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST; // Alineamos la entrada a la izquierda

        // Crear un panel para agrupar el campo de texto y el botón
        JPanel panelMensajeYBoton = new JPanel();
        panelMensajeYBoton.setBackground(new Color(70, 103, 144)); // Establecer el color de fondo igual al del panelCentral
        panelMensajeYBoton.setLayout(new BoxLayout(panelMensajeYBoton, BoxLayout.LINE_AXIS)); // Poner los componentes en línea

        entradaMissatge = new JTextField(10);
        entradaMissatge.setMaximumSize(new Dimension(200, 30));
        panelMensajeYBoton.add(entradaMissatge); // Añadir el campo de texto al panel

        botoEnviarMissatge = new JButton("Enviar Missatge");
        panelMensajeYBoton.add(Box.createRigidArea(new Dimension(5, 0))); // Espacio mínimo entre el campo de texto y el botón
        panelMensajeYBoton.add(botoEnviarMissatge); // Añadir el botón al panel

        panelCentral.add(panelMensajeYBoton, gbc); // Añadir el panel al layout

        // Mostrar mensaje encriptado
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Hacemos que ocupe dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Lo centramos
        labelMensajeEncriptado = new JLabel();
        labelMensajeEncriptado.setForeground(Color.WHITE);
        panelCentral.add(labelMensajeEncriptado, gbc);

        // Añadir los paneles a la ventana principal
        frame.add(panelSuperior, BorderLayout.NORTH); // El botón de cerrar sesión en la parte superior
        frame.add(panelCentral, BorderLayout.CENTER); // El contenido centrado
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame; // A todas las vistas porfa
    }

    // Método para actualizar la ficha del usuario
    public void actualitzarFitxa(String ficha) {
        fichaUsuari.setText("<html>" + ficha.replaceAll(", ", "<br>") + "</html>"); // Mejor formato con salto de línea
    }

    // Obtener el mensaje introducido por el espía
    public String getEntradaMissatge() {
        return entradaMissatge.getText();
    }

    // Mostrar el mensaje encriptado
    public void setMensajeEncriptado(String missatgeEncriptat) {
        labelMensajeEncriptado.setText("Mensaje Encriptado: " + missatgeEncriptat);
    }

    // Listener para el botón de enviar mensaje
    public void actionListenerBotoEnviarMensatge(ActionListener listener) {
        botoEnviarMissatge.addActionListener(listener);
    }

    // Listener para el botón de cerrar sesión
    public void actionListenerBotoCerrarSesion(ActionListener listener) {
        botoCerrarSesion.addActionListener(listener);
    }
}
