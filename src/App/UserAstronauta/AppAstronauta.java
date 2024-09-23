package App.UserAstronauta;


public class AppAstronauta {
    public static void main(String[] args) {

        // Crear la vista
        AstronautaView vista = new AstronautaView();

        // Crear el modelo
        AstronautaModel model = new AstronautaModel();

        // Crear el controlador
        AstronautaController controlador = new AstronautaController(vista, model);

    }
}
