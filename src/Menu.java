package interfaces;
import java.util.Scanner;



public class Menu {
    public void run() {
        while (menu() != 10) ;
    }

    private static int menu() {
        mostrar_opcoes();
        var option = ler_resposta_do_usuario();
        switch (option) {
            case 1:
                cadastrar_novo_operador();
                break;
            case 2:
                mostrar_operador_atual();
                break;
            case 3:
                trocar_operador();
                break;
            case 4:
                criar_conta();
                break;
            case 5:
                selecionar_conta();
                break;
            case 6:
                adicionar_movimento();
                break;
            case 7:
                consultar_movimentos();
                break;
            case 8:
                transferir_fundos();
                break;
            case 9:
                emitir_relatorio();
                break;
            case 10:
                System.out.println("Encerrando Programa...");
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
        System.out.println("2 -> Mostrar operador atual.");
        System.out.println("3 -> Trocar de operador.");
        System.out.println("4 -> Criar uma conta.");
        System.out.println("5 -> Selecionar uma conta.");
        System.out.println("6 -> Adicionar movimento à conta selecionada");
        System.out.println("7 -> Consultar movimentos da conta selecionada.");
        System.out.println("8 -> Transferir fundos de uma conta para a outra.");
        System.out.println("9 -> Emitir um relatório geral.");
        System.out.println("10 -> Terminar programa.");
    }

    private static Integer ler_resposta_do_usuario() {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o número do comando que deseja executar: ");
        var input = 100;
        try {
            input = in.nextInt();
        } catch (NumberFormatException exception) {
            System.out.println("O programa só aceita números inteiros.");
        }
        return input;
    }

    private static void cadastrar_novo_operador() {
        System.out.println("cadastrando novo operador.");
    }

    private static void mostrar_operador_atual() {
        System.out.println("mostrando operador atual.");
    }

    private static void trocar_operador() {
        System.out.println("trocando operador");
    }

    private static void criar_conta() {
        System.out.println("criando conta.");
    }

    private static void selecionar_conta() {
        System.out.println("selecionando conta.");
    }

    private static void adicionar_movimento() {
        System.out.println("adicionando novo movimento.");
    }

    private static void consultar_movimentos() {
        System.out.println("consultando movimentos.");
    }

    private static void transferir_fundos() {
        System.out.println("transferindo fundos.");
    }

    private static void emitir_relatorio() {
        System.out.println("emitindo relatórios.");
    }
}