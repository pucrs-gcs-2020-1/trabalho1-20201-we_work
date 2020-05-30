package entities;

import interfaces.Conta;
import app.Menu;

import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Operador {
    
    private int idOperador;
    private String nome;
    private String iniciais;
    Random rd = new Random();

    public Operador(int id, String nome) {
        this.idOperador = id;
        this.nome = nome;
        this.iniciais = "";

        for (String tmp : nome.split(" ")) {
            this.iniciais += tmp.toCharArray()[0];
        }
    }

    public int getIdOperador() {
        return this.idOperador;
    }

    public String getNome() {
        return this.nome;
    }

    public String getIniciais() {
        return this.iniciais;
    }

    public void criarConta(ArrayList<Conta> contas) {
        Menu.print("Digite o número da conta:");
        String idConta = Menu.in.next();

        boolean isValid = true;

        for (Conta c : contas) {
            if (c.getIdConta().equals(idConta)) {
                isValid = false;
            }
        }

        if (isValid) {
            Menu.print("Agora digite o nome do proprietário da conta:");
            Scanner in = new Scanner(System.in);
            String nome = in.nextLine();

            Conta conta = new ContaBancaria(idConta, nome, this.idOperador);

            contas.add(conta);

            Menu.print("Conta Criada");
        } else if(!isValid) {
            Menu.print("Número de conta já existente");
        }
    }

    public void transferencia(Conta d, Conta c, int v) {
        if (d.debito(v)) {

            c.credito(v);

            String s = "Transferencia realizada de " +
                    d.getNome() + " para " +
                    c.getNome() + ". Operador: " +
                    this.nome + ", data: " +
                    new Date();

            d.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), s, -v));
            c.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), s, v));

            Menu.print(s);
        } else {
            Menu.print("Nao foi possivel realizar a tranferencia para " + c.getNome());
        }
    }

    public void addCredito(Conta c, String d, int v) {
        c.credito(v);
        c.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), d, v));
        Menu.print("Valor " + Movimentacao.montaValor(v) + " creditado com sucesso!!");

    }

    public boolean pagarConta(Conta c, String d, int v) {
        if (c.debito(v)) {
            c.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), d, -v));
            Menu.print("Valor " + Movimentacao.montaValor(v) + " debitado com sucesso!!");

            return true;
        }
        
        Menu.print("Valor insuficiênte para pagar esta conta");

        return false;
    }

    @Override
    public String toString() {
        return "- Nome: " + this.nome + ", ID: " + this.idOperador;
    }
}