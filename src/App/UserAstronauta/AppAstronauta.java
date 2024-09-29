package App.UserAstronauta;


public class AppAstronauta {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No username provided");
            return;
        }
        String username = args[0];

        AstronautaView vista = new AstronautaView();

        AstronautaModel model = new AstronautaModel();

        AstronautaController controlador = new AstronautaController(vista, model, username);
    }
}
