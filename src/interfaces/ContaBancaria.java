

public class ContaBancaria implements Conta {
    protected double saldo = 0;
    protected String numero;
    private String nome;

    public ContaBancaria(String numero, String nome, double saldo) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    @Override
    public boolean saque(double valor) {
        if (this.saldo > 0 && this.saldo > valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void deposito(double valor) {
        this.saldo += valor;
    }

    @Override
    public boolean transferencia(ContaBancaria c, double valor) {
        if (this.saldo > 0 && this.saldo > valor) {
            this.saldo -= valor;
            c.deposito(valor);
            System.out.println("Transferencia realizada para " + c.nome);
            return true;
        }

        System.out.println("Nao foi possivel realizar a tranferencia para " + c.nome);

        return false;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String getNumeroConta() {
        return this.numero;
    }

    public String toString() {
        return String.format("%20s %20s %20s", numero, nome, saldo);
    }
}

