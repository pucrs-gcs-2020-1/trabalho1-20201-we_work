package app;

import entities.ContaBancaria;
import entities.Movimentacao;
import entities.Operador;
import java.util.Scanner;
import interfaces.Conta;
import java.util.ArrayList;

public class Menu {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Operador> operadores;
    static Operador operatorAtual;
    static ArrayList<Conta> contas;

    SistemaInicial sistemaInicial;

    public Menu() {
        this.sistemaInicial = new SistemaInicial();
        this.contas = sistemaInicial.getContas();
        operadores = new ArrayList<>();
        this.operatorAtual = new Operador(1, "Usuario Inicial Padrao");
        operadores.add(this.operatorAtual);
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

            for (Conta c : contas) {
                System.out.println("\t" + c.getNumeroConta());
            }

            System.out.println("Digite o numero da conta que deseja selecionar: \n");
            String numeroConta = in.nextLine();
            System.out.println("......");
            System.out.println("Conta selecionada");
            System.out.println("\n\n");

            System.out.println("1 -> Adicionar movimento à conta selecionada");
            System.out.println("2 -> Consultar movimentos da conta selecionada.");
            System.out.println("3 -> Transferir fundos de uma conta para a outra.");
            System.out.println("4 -> Emitir um relatório geral.");
            System.out.println("5 -> Retornar ao menu principal");

            int escolha = in.nextInt();

            switch (escolha) {
            case 1:
                adicionarMovimento();
                break;
            case 2:
                consultarMovimentos();
                break;
            case 3:
                System.out.println("Informe o número da conta origem:\n");
                String num_conta_origem = in.nextLine();
                ContaBancaria cOrigem = null;
                for (Conta c : contas) {
                    if (c.getNumeroConta().equals(num_conta_origem)) {
                        cOrigem = (ContaBancaria) c;
                        System.out.println("Conta Origem ok...");
                    } else {
                        System.out.println("Conta origem não encontrada");
                        break;
                    }
                }

                System.out.println("Informe o numero da conta destino:\n");
                String num_conta_destino = in.nextLine();
                ContaBancaria cDestino = null;
                for (Conta c : contas) {
                    if (c.getNumeroConta().equals(num_conta_destino)) {
                        cDestino = (ContaBancaria) c;
                        System.out.println("Conta destino ok...");
                    } else {
                        System.out.println("Conta destino não encontrada");
                        break;
                    }
                }
                System.out.println("Informe o valor desejado para transferência: \n");
                int valor = Integer.parseInt(in.nextLine());

                ArrayList<Movimentacao> m = new ArrayList<>();
                operatorAtual.transferencia(cOrigem, cDestino, valor, m);

                // operatorAtual.transferencia();
                break;
            case 4:
                emitirRelatorio();
                break;
            case 5:
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
        System.out.print("*******Operador Atual -> " + operatorAtual);
        System.out.println();
    }

    public static void trocarOperador() {
        System.out.println("Operadores: ");

        for (Operador op : operadores) {
            System.out.println(op);
        }

        System.out.print("Entre com ID do Operador: ");
        int identificador = in.nextInt();
        boolean temOp = false;

        for (Operador op : operadores) {
            if (op.getIdOperador() == identificador) {
                temOp = true;
                operatorAtual = op;
                System.out.println(operatorAtual.getNome() + " esta operando Agora!");
            }
        }

        if (!temOp) {
            System.out.println("Operador Invalido");
        }
        System.out.println("trocando operador");
    }

    private static void criarConta() {
        System.out.println("\nDigite o número da conta:\n");
        String numConta = in.nextLine();
        System.out.println("Agora digite o nome do proprietário da conta: \n");
        String nomeConta = in.nextLine();
        Conta conta = new ContaBancaria(numConta, nomeConta, operatorAtual.getIdOperador());
        contas.add(conta);
        System.out.println("Conta Criada. XD");
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