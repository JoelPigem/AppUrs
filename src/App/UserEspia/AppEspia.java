package App.UserEspia;


public class AppEspia {
    public static void main(String[] args) {
        // Asegurarnos de que se recibe el username desde el argumento
        if (args.length == 0) {
            System.err.println("No username provided");
            return;
        }
        String username = args[0];

        // Crear la vista
        EspiaView vista = new EspiaView();

        // Crear el modelo
        EspiaModel model = new EspiaModel();

        // Crear el controlador, pasando el username al modelo
        EspiaController controlador = new EspiaController(vista, model, username);
    }
}
