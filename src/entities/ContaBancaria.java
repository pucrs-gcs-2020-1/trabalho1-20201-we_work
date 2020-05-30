package entities;

import interfaces.Conta;

import java.util.ArrayList;
import java.util.Date;

public class ContaBancaria implements Conta {
    protected int saldo;
    protected String numero;
    private int idOperador;
    private String nome;
    private ArrayList<Movimentacao> movimentacoes;
    private Date dataCriacao;

    public ContaBancaria(String num, String n, int idOperador) {
        this.numero = num;
        this.nome = n;
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
    public String getNumeroConta() {
        return this.numero;
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
    public String toString() {
        // TODO
        return "";
    }
}

