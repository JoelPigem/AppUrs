package App.Mecanic;

import App.IniciSessio.IniciSessioController;
import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MecanicController {

    private MecanicView vista;
    private MecanicModel model;
    private IniciSessioModel iniciSessioModel;
    private IniciSessioView iniciSessioView;

    public MecanicController(MecanicView vista, MecanicModel model) {
        this.vista = vista;
        this.model = model;
        //this.iniciSessioModel = new IniciSessioModel();
        //this.iniciSessioView = new IniciSessioView();
        this.vista.actionListenerLlistar(new ListenerLlistar());
        this.vista.actionListenerImprimir(new actionListenerImprimir());
        this.vista.actionListenerFitxarEntrada(new actionListenerFitxarEntrada());

    }

    class ListenerLlistar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] cotxes = model.llistarCotxes();
                vista.actualitzarTaula(cotxes);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    class actionListenerImprimir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] cotxes = model.llistarCotxes();
                model.imprimirLlista(cotxes);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    class actionListenerFitxarEntrada implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.fitxarEntrada(model.obtenirID(iniciSessioView.getEntradaUsuari().getText(), iniciSessioView.getEntradaContrasenya().getText()));
                System.out.println("fitxat correctament");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

}
