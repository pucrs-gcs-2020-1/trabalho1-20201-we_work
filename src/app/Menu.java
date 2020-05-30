package app;

import entities.ContaBancaria;
import entities.Movimentacao;
import entities.Operador;

import java.util.Scanner;

import interfaces.Conta;

import java.util.ArrayList;

public class Menu {
    public static Scanner in = new Scanner(System.in);
    private ArrayList<Operador> operadores;
    private Operador operadorAtual;
    private Conta contaAtual;
    private ArrayList<Conta> contas;

    SistemaInicial sistemaInicial = new SistemaInicial();

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
                print(mostrarOperadorAtual());

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

                break;

            case 6:
                int valorTotal = 0;

                for (Conta c : contas) {
                    c.emitirRelatorio(operadores);
                    print("\n");
                    valorTotal += c.getSaldo();
                }

                print("Saldo geral da empresa: " + Movimentacao.montaValor(valorTotal));

                break;

            case 7:
                print("Finalizando o Programa");
                System.exit(0);
        }
        mostrarOpcoes();
    }

    public static void mostrarOpcoes() {
        print("\nGreetings!\n");
        print("1 -> Cadastrar um operador");
        print("2 -> Mostrar operador atual");
        print("3 -> Trocar de operador");
        print("4 -> Criar uma conta");
        print("5 -> Selecionar uma conta");
        print("6 -> Emitir um relatório geral");
        print("7 -> Terminar programa");
    }

    public static int lerRespostaDoUsuario() {
        print("Digite o número do comando que deseja executar:");

        try {
            return in.nextInt();
        } catch (NumberFormatException exception) {
            print("O programa só aceita números inteiros");
        }

        return 9;
    }

    private void cadastrarNovoOperador() {
        exibirOperadores();

        print("Digite o nome completo para o novo operador");
        String nome = "";
        in = new Scanner(System.in); // Gambeta
        nome = in.nextLine(); 

        boolean isInvalid = true;
        boolean newOperador = true;
        int id = -1;

        while (isInvalid && id == -1) {
            print("Digite um valor númerico inteiro para usar como id");
            id = in.nextInt();

            for (Operador o : operadores) {
                if (id == o.getIdOperador()) {
                    newOperador = false;
                    print("Já existe um operador com este ID. Por favor, digite outro valor.");
                } else {
                    isInvalid = false;
                }
            }
        }

        if (newOperador) {
            operadores.add(new Operador(id, nome));

            print("Novo Operador Cadastrado");
        }
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
                print(operadorAtual.getNome() + " esta operando Agora!");
            }
        }

        if (!temOp) {
            print("ID de Operador Inválido");
        }
    }

    private void selecionarConta() {
        print("Digite o número da conta que deseja selecionar");

        String numeroConta = in.next();
        Conta contaValida = null;

        for (Conta c : contas) {
            if (c.getIdConta().equals(numeroConta)) {
                contaValida = c;
            }
        }
        
        contaAtual = contaValida;

        if (!contaAtual.equals(null)) {
            contaAtual = contaValida;

            print("Conta selecionada");

            print("1 -> Adicionar crédito à conta selecionada");
            print("2 -> Consultar movimentos da conta selecionada");
            print("3 -> Transferir fundos de uma conta para a outra");
            print("4 -> Emitir um relatório da conta selecionada");
            print("5 -> Consultar movimentos da conta selecionada por operador");
            print("6 -> Consultar movimentos da conta selecionada por receita ou despesa");
            print("7 -> Pagar uma conta");

            int escolha = lerRespostaDoUsuario();

            switch (escolha) {
                case 1:
                    print("Escreva a descrição deste crédito");
                    String d = in.next();

                    print("Defina o valor para crédito em centavos");
                    int v = in.nextInt();

                    operadorAtual.addCredito(contaAtual, d, v);

                    break;

                case 2:
                    contaAtual.consultarMovimentacoes();

                    break;

                case 3:
                    exibirContas();
                    print("Informe o número da conta destino:");

                    String numContaDestino = in.next();

                    if (numContaDestino.equals(contaAtual.getIdConta())) {
                        print("Você não pode transferir para si mesmo");
                        break;
                    }

                    Conta contaDestino = contaAtual;

                    for (Conta c : contas) {
                        if (c.getIdConta().equals(numContaDestino)) {
                            contaDestino = c;
                        }
                    }

                    if (contaDestino == contaAtual){
                        print("Conta de destino invalida");
                        break;
                    }

                    print("Informe o valor desejado para transferência:");
                    int valor = in.nextInt();

                    operadorAtual.transferencia(contaAtual, contaDestino, valor);

                    break;

                case 4:
                    contaAtual.emitirRelatorio(operadores);

                    break;

                case 5:
                    print("digite o ID do operador");
                    exibirOperadores();

                    int idOperador = in.nextInt();

                    Operador op = null;

                    for (Operador o : operadores) {
                        if (o.getIdOperador() == idOperador) {
                            op = o;
                        }
                    }

                    if (op == null) {
                        print("ID de operador inválido");
                        break;
                    }

                    contaAtual.consultarMovimentacoes();

                    break;

                case 6:
                    print("digite o 1 (DESPESA) ou 2 (RECEITA)");
                    int opcao = in.nextInt();

                    contaAtual.consultarMovimentacoesPorDespesaOuReceita(opcao);

                    break;

                case 7:
                    print("Escreva uma descrição para a conta a ser paga");
                    Scanner in = new Scanner(System.in);
                    String d = in.nextLine();

                    print("Escreva o valor em centavos que deseja utilizar para pagar esta conta");
                    int v = in.nextInt();

                    if (v < 0) {
                        print("Você não pode pagar uma conta com valor negativo");

                        break;
                    }

                    operadorAtual.pagarConta(contaAtual, d, v);

                    break;

                default:
                    break;
            }
            
        } else if(contaAtual.equals(null)) {
            print("Conta Inválida");
        }
    }

    private void exibirOperadores() {
        print("No sistema existem os seguintes operadores cadastrados:\n");
        for (Operador o : operadores) print(o.toString());
    }

    private void exibirContas() {
        print("No sistema existem as seguintes contas:\n");
        for (Conta c : contas) print(c.getIdContaT());
    }

    public static void print(String s) {
        System.out.println("\n" + s);
    }
}