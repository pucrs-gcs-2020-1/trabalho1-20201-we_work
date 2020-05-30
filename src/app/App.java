package app;

public class App {
    public static void main(String[] args) {
        Menu.mostrarOpcoes();
        int option = Menu.lerRespostaDoUsuario();
        Menu m = new Menu();

        while (option != 9) {
            m.dashBoard(option);
            option = Menu.lerRespostaDoUsuario();
        }
    }
}