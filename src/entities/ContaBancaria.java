package entities;

import interfaces.Conta;

import java.util.ArrayList;
import java.util.Date;

public class ContaBancaria implements Conta {
    private int saldo;
    private String idConta;
    private int idOperador;
    private String nome;
    private ArrayList<Movimentacao> movimentacoes;
    private Date dataCriacao;

    public ContaBancaria(String idConta, String nome, int idOperador) {
        this.idConta = idConta;
        this.nome = nome;
        this.saldo = 0;
        this.idOperador = idOperador;
        this.movimentacoes = new ArrayList<Movimentacao>();
        this.dataCriacao = new Date();
    }

    @Override
    public void credito(int valor) {
        this.saldo += valor;
    }

    @Override
    public boolean debito(int valor) {
        if (this.saldo > 0 && this.saldo > valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public int getSaldo() {
        return this.saldo;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getIdConta() {
        return this.idConta;
    }

    @Override
    public ArrayList<Movimentacao> getMovimentacoes() {
        return this.movimentacoes;
    }

    @Override
    public Movimentacao addMovimentacao(Movimentacao m) {
        this.movimentacoes.add(m);
        return m;
    }

    @Override
    public void consultarMovimentacoes() {
        for (Movimentacao m : this.movimentacoes) Menu.print(m);
    }

    @Override
    public void consultarMovimentacoesPorDespesaOuReceita(int s) {
        for (Movimentacao m : this.movimentacoes) {
            if (s == 1)
                if (m.getValorMonetario() < 0) Menu.print(m);
            if (s == 2)
                if (m.getValorMonetario() > 0) Menu.print(m);
        }
    }

    @Override
    public void emitirRelatorio(ArrayList<Operador> operadores) {
        String nome = "", iniciais = "";

        for (Operador o : operadores) {
            if (o.getIdOperador() == this.idOperador) {
                nome = o.getNome();
                iniciais = o.getIniciais();
            }
        }

        Menu.print(
                "Conta " + this.idConta
                        + ", criada por " + nome
                        + "(" + iniciais + ")"
                        + " em " + this.dataCriacao
        );

        for (Movimentacao m : this.movimentacoes) Menu.print(m);

        Menu.print("Saldo atual: " + Movimentacao.montaValor(this.saldo));
    }
}

