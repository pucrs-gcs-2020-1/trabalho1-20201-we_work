public interface Conta {
    public boolean saque(double valor);

    public void deposito(double valor);

    public boolean transferencia(ContaBancaria c, double valor);

    public double getSaldo();

    public String getNumeroConta();
}
