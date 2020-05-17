public class App {
    public static void main(String[] args) {

        System.out.println("Hello World");
        ContaBancaria c1 = new ContaBancaria("33","Rafael");
        ContaBancaria c2 = new ContaBancaria("69","Fulano");
        c1.deposito(7000);
        c1.transferencia(c2,79);
        System.out.println(c2.getSaldo());
    }
}