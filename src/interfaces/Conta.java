package interfaces;
import entities.Movimentacao;

import java.util.ArrayList;

public interface Conta {
    public void credito(int valor);
    
    public boolean debito(int valor);

    public int getSaldo();

    public String getNome();

    public String getNumeroConta();

    public ArrayList<Movimentacao> getMovimentacoes();

    public Movimentacao addMovimentacao(Movimentacao m);
}
