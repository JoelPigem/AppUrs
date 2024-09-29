package App.UserEspia;


public class AppEspia {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("No username provided");
            return;
        }
        String username = args[0];


        EspiaView vista = new EspiaView();


        EspiaModel model = new EspiaModel();

        EspiaController controlador = new EspiaController(vista, model, username);
    }
}
