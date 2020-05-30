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
    static Operador operadorAtual;
    static Conta contaAtual;
    static ArrayList<Conta> contas;

    SistemaInicial sistemaInicial;

    public Menu() {
        this.sistemaInicial = new SistemaInicial();
        this.contas = sistemaInicial.getContas();
        this.operadorAtual = new Operador(1, "Usuario Inicial Padrao");

        operadores = new ArrayList<>();
        operadores.add(this.operadorAtual);
    }

    public void dashBoard(int option) {
        switch (option) {
            case 1:
                cadastrarNovoOperador();
                break;

            case 2:
                System.out.println(mostrarOperadorAtual());
                break;

            case 3:
                trocarOperador();
                break;

            case 4:
                operadorAtual.criarConta(contas);
                break;

            case 5:
                exibirContas();
                selecionarConta();

            case 6:
                int valorTotal = 0;

                for (Conta c : contas) {
                    c.emitirRelatorio(operadorAtual);
                    valorTotal += c.getSaldo();
                }

                System.out.println("Saldo geral da empresa: " + Movimentacao.montaValor(valorTotal));

                break;

            case 7:
                System.out.println("Finalizando o Programa");
                System.exit(0);
        }
    }

    public static void mostrarOpcoes() {
        System.out.println("Greetings!");
        System.out.println("1 -> Cadastrar um operador");
        System.out.println("2 -> Mostrar operador atual");
        System.out.println("3 -> Trocar de operador");
        System.out.println("4 -> Criar uma conta");
        System.out.println("5 -> Selecionar uma conta");
        System.out.println("6 -> Emitir um relatório geral");
        System.out.println("7 -> Terminar programa");
    }

    public static int lerRespostaDoUsuario() {
        System.out.println("Digite o número do comando que deseja executar:");

        try {
            return in.nextInt();
        } catch (NumberFormatException exception) {
            System.out.println("O programa só aceita números inteiros");
        }

        return 9;
    }

    private void cadastrarNovoOperador() {
        exibirOperadores();

        System.out.println("Digite o nome completo para o novo operador");
        String nome = in.nextLine();

        boolean isInvalid = true;
        /// TODO: Rever
        int id = 0;

        while (isInvalid) {
            System.out.println("Digite um valor númerico inteiro para usar como id");
            id = in.nextInt();

            for (Operador o : operadores) {
                if (id == o.getIdOperador()) {
                    System.out.println("Já existe um operador com este ID. Por favor, digite outro valor.");
                } else {
                    isInvalid = false;
                }
            }
        }

        operadores.add(new Operador(id, nome));

        System.out.println("Novo Operador Cadastrado");
    }

    private String mostrarOperadorAtual() {
        return "Operador Atual - > " + operadorAtual;
    }

    private void trocarOperador() {
        exibirOperadores();

        System.out.print("Entre com ID do Operador: ");
        int identificador = in.nextInt();

        boolean temOp = false;

        for (Operador o : operadores) {
            if (o.getIdOperador() == identificador) {
                temOp = true;
                operadorAtual = o;
                System.out.println(operadorAtual.getNome() + " esta operando Agora!");
            }
        }

        if (!temOp) {
            System.out.println("ID de Operador Inválido");
        }
    }

    private void selecionarConta() {
        System.out.println("Digite o número da conta que deseja selecionar: \n");

        String numeroConta = in.nextLine();

        for (Conta c : contas) {
            if (c.getIdConta() == numeroConta) {
                contaAtual = c;
            }
        }

        System.out.println("Conta selecionada\n\n");

        System.out.println("1 -> Adicionar crédito à conta selecionada");
        System.out.println("2 -> Consultar movimentos da conta selecionada");
        System.out.println("3 -> Transferir fundos de uma conta para a outra");
        System.out.println("4 -> Emitir um relatório da conta selecionada");
        System.out.println("5 -> Consultar movimentos da conta selecionada por operador");
        System.out.println("6 -> Consultar movimentos da conta selecionada por receita ou despesa");
        System.out.println("Digite qualquer coisa para retornar ao menu principal");

        int escolha = lerRespostaDoUsuario();

        switch (escolha) {
            case 1:
                System.out.println("Escreva a descrição deste crédito");
                String d = in.nextLine();

                System.out.println("Defina o valor para crédito");
                int v = in.nextInt();

                operadorAtual.addCredito(contaAtual, d, v);

                break;

            case 2:
                /// TODO: Rever
                contaAtual.consultarMovimentacoes();

                break;

            case 3:
                exibirContas();
                System.out.println("Informe o número da conta destino:");

                String numContaDestino = in.nextLine();

                if (numContaDestino.equals(contaAtual.getIdConta())) {
                    System.out.println("Você não pode transferir para si mesmo");
                    break;
                }

                Conta contaDestino = contaAtual;

                for (Conta c : contas) {
                    if (c.getIdConta().equals(numContaDestino)) {
                        contaDestino = c;
                    } else {
                        System.out.println("Conta de destino invalida");
                        break;
                    }
                }

                System.out.println("Informe o valor desejado para transferência:");
                int valor = in.nextInt();

                operadorAtual.transferencia(contaAtual, contaDestino, valor);

                break;

            case 4:
                /// TODO: Rever
                contaAtual.emitirRelatorio();
                break;

            case 5:
                System.out.println("digite o ID do operador");
                exibirOperadores();

                int idOperador = in.nextInt();

                Operador op = null;

                for (Operador o : operadores) {
                    if (o.getIdOperador() == idOperador) {
                        op = o;
                    }
                }

                if (op == null) {
                    System.out.println("ID de operador inválido");
                    break;
                }

                contaAtual.consultarMovimentacoes(op);

                break;

            case 6:
                System.out.println("digite o 1 (DESPESA) ou 2 (RECEITA)");
                int opcao = in.nextInt();

                contaAtual.consultarMovimentacoesPorDespesaOuReceita(opcao);
                break;

            default:
                break;
        }
    }

    private void exibirOperadores() {
        System.out.println("No sistema existem os seguintes operadores cadastrados:\n");
        for (Operador o : operadores) System.out.println(o);
    }

    private void exibirContas() {
        System.out.println("No sistema existem as seguintes contas:\n");
        for (Conta c : contas) System.out.println(c.getIdConta());
    }
}