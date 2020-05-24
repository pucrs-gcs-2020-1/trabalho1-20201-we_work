import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        ArrayList<ContaBancaria> contas;
        ArrayList<Operador> operadores = new ArrayList<>();
        SistemaInicial s = new SistemaInicial();
        contas = s.getContas();
        Operador operatorAtual = new Operador(1, "Usuario Inicial Padrao");
        operadores.add(operatorAtual);
        int option;
        do {
            mostrarOpcoes();
            option = lerRespostaDoUsuario();
            switch (option) {
                case 1:
                    System.out.print("*******Nome Completo: ");
                    String nome = in.nextLine();
                    System.out.print("*******ID: ");
                    int id = Integer.parseInt(in.nextLine());
                    boolean temOp = false;
                    for (Operador op : operadores) {
                        if (op.getId() == id) {
                            temOp = true;
                        }
                    }
                    if (temOp == false) {
                        System.out.println("Novo Operador Cadastrado. XD");
                        Operador op = new Operador(id, nome);
                        operadores.add(op);
                    } else {
                        System.out.println("****** Ja exite um operador com este Identificador ******");
                    }
                    break;
                case 2:
                    System.out.print("*******Operador Atual -> " + operatorAtual);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Operadores: ");
                    for (Operador op : operadores ) {
                        System.out.println(op);
                    }
                    System.out.print("Entre com ID do Operador: ");
                    int identificador = Integer.parseInt(in.nextLine());
                    temOp = false;
                    for (Operador op: operadores) {
                        if(op.getId() == identificador){
                            temOp = true;
                            operatorAtual = op;
                            System.out.println(operatorAtual.getNomeCompleto() + " esta operando Agora!");
                        }
                    }
                    if (temOp == false){
                        System.out.println("Operador Invalido");
                    }
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