import java.util.Date;

public class ContaBancaria implements Conta {
    protected int saldo = 0;
    protected String numero;
    private int idOperador
    private String nome;
    private ArrayList<Movimentacao> movimentacoes;
    private Date dataCriacao;

    public ContaBancaria(String num, String n, double s, int idOperador) {
        this.numero = num;
        this.nome = n;
        this.saldo = s;
        this.idOperador = idOperador;
        this.movimentacoes = new ArrayList<Movimentacao>;
        this.dataCriacao = new Date();
    }

    @Override
    public void credito(double valor) {
        this.saldo += valor;
    }

    @Override
    public boolean debito(double valor) {
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
    };
    
    @Override
    public void addMovimentacao(Movimentacao m) {
        this.movimentacoes.add(m);
    };

    @Override
    public String toString() {
        // TODO
    }
}

