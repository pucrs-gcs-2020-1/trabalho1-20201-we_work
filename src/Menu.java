public class Menu {

    public void run() {

        while (menu() != 9);
    }

    private static int menu() {

        mostrar_opcoes();

        var option = ler_resposta_do_usuario();
        switch (option) {
            case 1:
                cadastrar_novo_operador();
                break;

            case 2:
                trocar_operador();
                break;

            case 3:
                criar_conta();
                break;

            case 4:
                selecionar_conta();
                break;

            case 5:
                adicionar_movimento();
                break;

            case 6:
                consultar_movimentos();
                break;

            case 7:
                transferir_fundos();
                break;

            case 8:
                emitir_relatorio();
                break;

            case 9:
            case 10:
                break;

            default:
                System.out.println("Opção inválida, por favor digite novamente.");
                break;
        }
        return option;
    }

    private static void mostrar_opcoes() {
        System.out.println("Greetings!");
        System.out.println("1 -> Cadastrar um operador.");
        System.out.println("2 -> Trocar de operador.");
        System.out.println("3 -> Criar uma conta.");
        System.out.println("4 -> Selecionar uma conta.");
        System.out.println("5 -> Adicionar movimento à conta selecionada");
        System.out.println("6 -> Consultar movimentos da conta selecionada.");
        System.out.println("7 -> Transferir fundos de uma conta para a outra.");
        System.out.println("8 -> Emitir um relatório geral.");
        System.out.println("9 -> Terminar programa.");
    }

    private static Integer ler_resposta_do_usuario() {

        System.out.print("Digite um número: ");

        var input = 10;

        try {
            input = Integer.parseInt(
                        System.console()
                              .readLine()
                              .strip()
                    );

        } catch (NumberFormatException exception) {
            System.out.println("O programa só aceita números inteiros.");
        }

        return input;
    }

    private static boolean cadastrar_novo_operador() {
        System.out.println("cadastrando novo operador.");
        return true;
    }

    private static boolean trocar_operador() {
        System.out.println("trocando operador");
        return true;
    }

    private static boolean criar_conta() {
        System.out.println("criando conta.");
        return true;
    }

    private static boolean selecionar_conta() {
        System.out.println("selecionando conta.");
        return true;
    }

    private static boolean adicionar_movimento() {
        System.out.println("adicionando novo movimento.");
        return true;
    }

    private static boolean consultar_movimentos() {
        System.out.println("consultando movimentos.");
        return true;
    }

    private static boolean transferir_fundos() {
        System.out.println("transferindo fundos.");
        return true;
    }

    private static boolean emitir_relatorio() {
        System.out.println("emitindo relatórios.");
        return true;
    }
}