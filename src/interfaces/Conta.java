package interfaces;

import entities.Movimentacao;
import entities.Operador;

import java.util.ArrayList;

public interface Conta {
    public void credito(int valor);

    public boolean debito(int valor);

    public int getSaldo();

    public String getNome();

    public String getIdConta();

    public ArrayList<Movimentacao> getMovimentacoes();

    public Movimentacao addMovimentacao(Movimentacao m);

    public void consultarMovimentacoes();

    public void emitirRelatorio(ArrayList<Operador> operadores);

    public void consultarMovimentacoesPorDespesaOuReceita(int s);
}
