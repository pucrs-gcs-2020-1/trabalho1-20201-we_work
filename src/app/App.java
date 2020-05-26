package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import interfaces.*;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>();
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

                break;

            case 4:
                System.out.println("\nDigite o número da conta:\n");
                String numConta = "";
                numConta = getTeclado();
                System.out.println("Agora digite o nome do proprietário da conta: \n");
                String nome_conta = "";
                nome_conta = getTeclado();
                ContaBancaria count = new ContaBancaria(numConta, nome_conta, 0.0);
                contas.add(count);
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

        } while (option != 10);
    }

    public static void mostrarOpcoes() {
        System.out.println("Greetings!");
        System.out.println("1 -> Cadastrar um operador.");
        System.out.println("2 -> Mostrar operador atual.");
        System.out.println("3 -> Trocar de operador.");
        System.out.println("4 -> Criar uma conta.");
        System.out.println("5 -> Selecionar uma conta.");
        System.out.println("6 -> Terminar programa.");
    }

    public static Integer lerRespostaDoUsuario() {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o número do comando que deseja executar: ");
        int input = 100;

        try {
            input = in.nextInt();
        } catch (NumberFormatException exception) {
            System.out.println("O programa só aceita números inteiros.");
        }

        return input;
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

    public static String getTeclado() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String _entrada = in.readLine();
        
        return _entrada;
    }

}