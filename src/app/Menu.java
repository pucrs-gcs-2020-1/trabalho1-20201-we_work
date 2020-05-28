package app;

import entities.Operador;
import java.util.Scanner;
import interfaces.Conta;
import java.util.ArrayList;

public class Menu {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Operador> operadores;
    
    Operador operatorAtual;
    SistemaInicial sistemaInicial;
    ArrayList<Conta> contas;

    public Menu() {
        this.sistemaInicial = new SistemaInicial();
        this.contas = sistemaInicial.getContas();
        this.operadores = new ArrayList<>();
        this.operatorAtual = new Operador(1, "Usuario Inicial Padrao");
        this.operadores.add(this.operatorAtual);
    }

    public static void dashBoard(int option) {
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
                System.out.println("\n\n\n");
                System.out.println("\tNº das contas cadastradas:");

                for (ContaBancaria c : contas) {
                    System.out.println("\t" + c.getNumeroConta());
                }

                System.out.println("Digite o numero da conta que deseja selecionar: \n");
                String nu_conta = getTeclado();
                System.out.println("......");
                System.out.println("Conta selecionada");
                System.out.println("\n\n");

                System.out.println("1 -> Adicionar movimento à conta selecionada");
                System.out.println("2 -> Consultar movimentos da conta selecionada.");
                System.out.println("3 -> Transferir fundos de uma conta para a outra.");
                System.out.println("4 -> Emitir um relatório geral.");
                System.out.println("5 -> Retornar ao menu principal");

                String menu = getTeclado();

                switch (menu) {
                    case "1":
                        adicionarMovimento();
                        break;

                    case "2":
                        consultarMovimentos();
                        break;

                    case "3":
                        transferirFundos();
                        break;
                    case "4":
                        emitirRelatorio();
                        break;
                    case "5":
                        break;
                }
                break;
            case 6:
                System.out.println("Encerrando Programa...");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida, por favor digite novamente.");
                break;
        }
        mostrarOpcoes();
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
        System.out.println("8 -> Transferir fundos.");
        System.out.println("9 -> Emitir um relatório geral.");
        System.out.println("10 -> Terminar programa.");
    }

    public static int lerRespostaDoUsuario() {
        System.out.print("Digite o número do comando que deseja executar: ");
        try {
            return in.nextInt();
        } catch (NumberFormatException exception) {
            System.out.println("O programa só aceita números inteiros.");
        }
        return 10;
    }

    private static void cadastrarNovoOperador() {
        System.out.print("*******Nome Completo: ");
        String nome = in.nextLine();
        System.out.print("*******ID: ");
        int id = lerRespostaDoUsuario();
        boolean temOp = false;

        for (Operador op : operadores) {
            if (op.getIdOperador() == id) {
                temOp = true;
            }
        }

        if (!temOp) {
            System.out.println("Novo Operador Cadastrado. XD");
            Operador op = new Operador(id, nome);
            operadores.add(op);
        } else {
            System.out.println("****** Ja exite um operador com este Identificador ******");
        }
        System.out.println("cadastrando novo operador.");
    }

    private static void mostrarOperadorAtual() {
        System.out.print("*******Operador Atual -> " + this.operatorAtual);
        System.out.println();
    }

    private static void trocarOperador() {
        System.out.println("Operadores: ");

        for (Operador op : operadores) {
            System.out.println(op);
        }

        System.out.print("Entre com ID do Operador: ");
        int identificador = Integer.parseInt(in.nextLine());
        temOp = false;

        for (Operador op : operadores) {
            if (op.getId() == identificador) {
                temOp = true;
                operatorAtual = op;
                System.out.println(operatorAtual.getNomeCompleto() + " esta operando Agora!");
            }
        }

        if (temOp == false) {
            System.out.println("Operador Invalido");
        }
        System.out.println("trocando operador");
    }

    private static void criarConta() {
        System.out.println("\nDigite o número da conta:\n");
        String numConta = "";
        numConta = getTeclado();
        System.out.println("Agora digite o nome do proprietário da conta: \n");
        String nome_conta = "";
        nome_conta = getTeclado();
        ContaBancaria count = new ContaBancaria(numConta, nome_conta, 0.0);
        contas.add(count);
        System.out.println("criando conta.");
    }

    private static void selecionarConta() {
        System.out.println("selecionando conta.");
    }

    private static void adicionarMovimento() {
        System.out.println("adicionando novo movimento.");
    }

    private static void consultarMovimentos() {
        System.out.println("consultando movimentos.");
    }

    private static void trasferirFundos() {
        System.out.println("transferindo fundos.");
    }

    private static void emitirRelatorio() {
        System.out.println("emitindo relatórios.");
    }
}