import java.util.ArrayList;
import java.util.List;

public class AppTestesDeFuncionalidade {
    public static void main(String[] args) {

        System.out.println("Hello World");
        ContaBancaria c1 = new ContaBancaria("33","Rafael",40000);
        ContaBancaria c2 = new ContaBancaria("69","Fulano",50000);
        c1.deposito(7000);
        c1.transferencia(c2,79);
        System.out.println(c2.getSaldo());

        SistemaInicial sis = new SistemaInicial();
        ArrayList<ContaBancaria> contas = sis.getContas();

        for (ContaBancaria contaBancaria : contas) {
            System.out.println(contaBancaria.getNumeroConta()+" "+contaBancaria.getSaldo());
        }

        double cont=0;
        String ax = "Conta Bancaria \n";
        ax+=String.format("%20s %20s %20s","Numero", "Nome","Saldo")+"\n";
        for (ContaBancaria r: contas) {
            ax += r.toString()+"\n";
            cont+=r.getSaldo();
        }
        System.out.println(ax);
        System.out.println(String.format("%40s %20s","Saldo Total: ",cont));
        ArrayList<Operador> opr = new ArrayList<>();

        opr.add(new Operador(1,"Rafael Dias Puhl"));

        for (Operador op:opr ) {
            System.out.println(op);
        }
    }
}