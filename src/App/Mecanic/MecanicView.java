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
    private JTextArea fichaUsuari;
    private JButton botoCerrarSession;

    public MecanicView() {

        frame = new JFrame("Mecànic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        botoLlistar = new JButton("Llistar");
        botoCerrarSession = new JButton("Tancar Sessio");
        botoImprimir = new JButton("Imprimir");
        fitxarEntrada = new JButton("Entrada");
        fitxarSortida = new JButton("Sortida");


        Dimension buttonSize = new Dimension(120, 30);
        botoLlistar.setPreferredSize(buttonSize);
        botoImprimir.setPreferredSize(buttonSize);
        fitxarEntrada.setPreferredSize(buttonSize);
        fitxarSortida.setPreferredSize(buttonSize);
        botoCerrarSession.setPreferredSize(buttonSize);


        JPanel buttonTopPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonTopPanel.add(fitxarEntrada);
        buttonTopPanel.add(fitxarSortida);
        buttonTopPanel.add(botoCerrarSession);
        buttonTopPanel.setBackground(new Color(213, 21, 21)); // Fondo azul


        fichaUsuari = new JTextArea(10, 20);
        fichaUsuari.setLineWrap(true);
        fichaUsuari.setWrapStyleWord(true);
        fichaUsuari.setEditable(false);
        fichaUsuari.setForeground(Color.WHITE);
        fichaUsuari.setBackground(new Color(213, 21, 21));  // Color de fondo azul
        fichaUsuari.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Márgenes


        JScrollPane fichaScroll = new JScrollPane(fichaUsuari);
        fichaScroll.setPreferredSize(new Dimension(300, 300));  // Ocupa toda la parte izquierda
        fichaScroll.setBorder(BorderFactory.createEmptyBorder());


        String[] columnNames = {"ID_MECANIC", "ID_COTXE", "MARCA", "MODEL", "PROBLEMA"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 150));


        JPanel mainPanel = new JPanel(new BorderLayout(20, 20)); // Márgenes internos
        mainPanel.setBackground(new Color(213, 21, 21));  // Fondo azul


        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(fichaScroll, BorderLayout.NORTH);  // Añadir la ficha al norte
        leftPanel.setBackground(new Color(213, 21, 21));


        JPanel rightTopPanel = new JPanel(new BorderLayout());
        rightTopPanel.add(buttonTopPanel, BorderLayout.NORTH);


        JPanel rightBottomPanel = new JPanel(new BorderLayout());
        rightBottomPanel.add(scrollPane, BorderLayout.CENTER);


        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.add(rightTopPanel, BorderLayout.NORTH);  // Botones arriba
        rightPanel.add(rightBottomPanel, BorderLayout.CENTER);  // Tabla debajo
        rightPanel.setBackground(new Color(213, 21, 21));


        JPanel buttonBottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonBottomPanel.add(botoLlistar);
        buttonBottomPanel.add(botoImprimir);
        buttonBottomPanel.setBackground(new Color(213, 21, 21)); // Fondo azul


        rightBottomPanel.add(buttonBottomPanel, BorderLayout.SOUTH);


        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);


        frame.add(mainPanel);
        frame.setVisible(true);
    }


    public void actionListenerLlistar(ActionListener listener) {
        botoLlistar.addActionListener(listener);
    }

    public void actionListenerImprimir(ActionListener listener) {
        botoImprimir.addActionListener(listener);
    }

    public void actionListenerFitxarEntrada(ActionListener listener) {
        fitxarEntrada.addActionListener(listener);
    }

    public void actionListenerFitxarSortida(ActionListener listener) {
        fitxarSortida.addActionListener(listener);
    }

    public void actionListenerTancarSessio(ActionListener listener) {
        botoCerrarSession.addActionListener(listener);
    }

    // Método para actualizar la tabla
    public void actualitzarTaula(Object[][] data) {
        tableModel.setRowCount(0);  // Limpiar la tabla
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }

    // Método para actualizar la ficha de usuario
    public void actualitzarFitxa(String ficha) {
        fichaUsuari.setText(ficha.replaceAll(", ", "\n"));  // Formato con salto de línea
    }

    public JFrame getFrame() {
        return frame;
    }

    public void actionListenerBotoCerrarSesion(ActionListener listener) {
        botoCerrarSession.addActionListener(listener);
    }
}
