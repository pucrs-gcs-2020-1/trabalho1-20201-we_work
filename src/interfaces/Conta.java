package interfaces;
import Movimentacao;

public interface Conta {
    public void credito(double valor);
    
    public boolean debito(double valor);

    public int getSaldo();

    public String getNome();

    public String getNumeroConta();

    public ArrayList<Movimentacao> getMovimentacoesByIdConta(int idConta);

    public void addMovimento(Movimentacao m);
}
