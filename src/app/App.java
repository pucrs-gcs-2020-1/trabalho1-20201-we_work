package app;

public class App {
    public static void main(String[] args) {
        Menu.mostrarOpcoes();
        int option = Menu.lerRespostaDoUsuario();

        while (option != 10) {
            Menu.dashBoard(option);
            option = Menu.lerRespostaDoUsuario();
        }
    }
}