package App.UserEspia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EspiaView {
    private JFrame frame;
    private JButton botoEnviarMissatge, botoCerrarSesion;
    private JButton fitxarEntrada, fitxarSortida;
    private JLabel fichaUsuari, labelMissatge, labelMensajeEncriptado;
    private JTextField entradaMissatge;

    EspiaView() {
        frame = new JFrame("Espia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Crear un panel para la parte superior, donde irá el botón de cerrar sesión
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(213, 21, 21));

        botoCerrarSesion = new JButton("Cerrar Sesión");
        panelSuperior.add(botoCerrarSesion, BorderLayout.WEST); // Ubicamos el botón a la izquierda

        // Crear un panel central para centrar los elementos restantes
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(new Color(213, 21, 21));
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

        // Sección de envío de mensajes - Entrada de texto y botón
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;

        entradaMissatge = new JTextField();
        entradaMissatge.setPreferredSize(new Dimension(200, 30)); // Ajustar el tamaño del campo de texto
        entradaMissatge.setColumns(20); // Añadir columnas para el tamaño horizontal

        // Añadir campo de texto
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permitir que el JTextField se expanda horizontalmente
        panelCentral.add(entradaMissatge, gbc);

        // Añadir botón "Enviar Missatge"
        gbc.gridy++;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        botoEnviarMissatge = new JButton("Enviar Missatge");
        panelCentral.add(botoEnviarMissatge, gbc);

        // Mostrar mensaje encriptado
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Hacemos que ocupe dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Lo centramos
        labelMensajeEncriptado = new JLabel();
        labelMensajeEncriptado.setForeground(Color.WHITE);
        panelCentral.add(labelMensajeEncriptado, gbc);

        // Añadir botones de Entrada y Sortida
        JPanel panelBotonsFitxar = new JPanel();
        panelBotonsFitxar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Espaciado entre botones
        panelBotonsFitxar.setBackground(new Color(213, 21, 21));

        fitxarEntrada = new JButton("Entrada");
        fitxarSortida = new JButton("Sortida");
        panelBotonsFitxar.add(fitxarEntrada);
        panelBotonsFitxar.add(fitxarSortida);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(panelBotonsFitxar, gbc); // Agregar los botones al panel

        // Añadir los paneles a la ventana principal
        frame.add(panelSuperior, BorderLayout.NORTH); // El botón de cerrar sesión en la parte superior
        frame.add(panelCentral, BorderLayout.CENTER); // El contenido centrado
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
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

    // Listener para el botón de Entrada
    public void actionListenerFitxarEntrada(ActionListener listener) {
        fitxarEntrada.addActionListener(listener);
    }

    // Listener para el botón de Sortida
    public void actionListenerFitxarSortida(ActionListener listener) {
        fitxarSortida.addActionListener(listener);
    }
}
