package App.Mecanic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class MecanicView {
    private JFrame frame;
    private JButton botoLlistar;
    private JButton botoImprimir;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton fitxarEntrada;
    private JButton fitxarSortida;

    public MecanicView() {
        // Inicialización del frame
        frame = new JFrame("Mecànic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Inicialización de los botones
        botoLlistar = new JButton("Llistar");
        botoImprimir = new JButton("Imprimir");
        fitxarEntrada = new JButton("Entrada");
        fitxarSortida = new JButton("Sortida");

        // Añadir bordes y espaciado a los botones
        botoLlistar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botoImprimir.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Crear un panel para los botones con FlowLayout centrado
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Espaciado entre botones
        buttonPanel.add(botoLlistar);
        buttonPanel.add(botoImprimir);
        buttonPanel.add(fitxarEntrada);
        buttonPanel.add(fitxarSortida);

        // Cambiar el color de fondo del panel de botones para que coincida con el fondo general
        buttonPanel.setBackground(new Color(44, 62, 80));

        // Crear la tabla con el modelo
        String[] columnNames = {"ID_MECANIC", "ID_COTXE", "MARCA", "MODEL", "PROBLEMA"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Establecer un tamaño preferido para que la tabla no ocupe toda la pantalla
        scrollPane.setPreferredSize(new Dimension(600, 150));

        // Cambiar el color de fondo del JScrollPane (el área detrás de la tabla)
        //scrollPane.getViewport().setBackground(new Color(44, 62, 80));  // Fondo azul del área de la tabla

        // Añadir un borde vacío alrededor del JScrollPane para crear márgenes
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Centrar la tabla
        tablePanel.add(scrollPane);  // Añadir la tabla al panel
        tablePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  // Márgenes
        tablePanel.setBackground(new Color(44, 62, 80));  // Fondo azul para el panel de la tabla

        // Crear un panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(44, 62, 80));  // Fondo azul para el panel principal

        // Añadir el JScrollPane en el centro del panel principal
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Añadir el panel de botones en la parte inferior
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Añadir el panel principal al frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void actionListenerLlistar(ActionListener listener) {botoLlistar.addActionListener(listener);}
    public void actionListenerImprimir(ActionListener listener) {botoImprimir.addActionListener(listener);}

    public void actualitzarTaula(Object[][] data) {

        tableModel.setRowCount(0);

        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }

    public void actionListenerFitxarEntrada(ActionListener listener) {fitxarEntrada.addActionListener(listener);}
    public void actionListenerFitxarSortida(ActionListener listener) {fitxarSortida.addActionListener(listener);}

}
