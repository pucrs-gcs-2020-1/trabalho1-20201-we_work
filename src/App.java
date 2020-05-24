import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        List<ContaBancaria> contas;
        SistemaInicial s = new SistemaInicial();
        contas = s.getContas();
        int option;
        do {
            mostrarOpcoes();
            option = lerRespostaDoUsuario();
            switch (option) {
                case 1:
                    cadastrarNovoOperador();
                    break;
                case 2:
                    mostrarOperadorAtual();
                    break;
                case 3:
                    trocarOperador();
                    break;
                case 4:
                    criarConta();
                    break;
                case 5:
                    selecionarConta();
                    break;
                case 6:
                    adicionarMovimento();
                    break;
                case 7:
                    consultarMovimentos();
                    break;
                case 8:
                    transferirFundos();
                    break;
                case 9:
                    emitirRelatorio();
                    break;
                case 10:
                    System.out.println("Encerrando Programa...");
                    Thread.sleep(3000);
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite novamente.");
                    break;
            }
        } while (option != 10);
    }

    public static void mostrarOpcoes() {
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

    public static Integer lerRespostaDoUsuario() {
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

    public static void cadastrarNovoOperador() {
        System.out.println("cadastrando novo operador.");
    }

    public static void mostrarOperadorAtual() {
        System.out.println("mostrando operador atual.");
    }

    public static void trocarOperador() {
        System.out.println("trocando operador");
    }

    public static void criarConta() {
        System.out.println("criando conta.");
    }

    public static void selecionarConta() {
        System.out.println("selecionando conta.");
    }

    public static void adicionarMovimento() {
        System.out.println("adicionando novo movimento.");
    }

    public static void consultarMovimentos() {
        System.out.println("consultando movimentos.");
    }

    public static void transferirFundos() {
        System.out.println("transferindo fundos.");
    }

    public static void emitirRelatorio() {
        System.out.println("emitindo relatórios.");
    }
}