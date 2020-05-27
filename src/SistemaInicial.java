import java.util.ArrayList;

public class SistemaInicial {
    private ArrayList<ContaBancaria> contas;

    public SistemaInicial() {
        this.contas = new ArrayList<>();
        ContaBancaria c1 = new ContaBancaria("789456", "Mick Jagger",200);
        ContaBancaria c2 = new ContaBancaria("321539", "Maik Tyson", 5000);
        ContaBancaria c3 = new ContaBancaria("666666", "Angus Young", 8000);
        ContaBancaria c4 = new ContaBancaria("147951", "Cindy Louper", 808);
        ContaBancaria c5 = new ContaBancaria("888488", "Mohamed Ali", 10);
        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
        contas.add(c4);
        contas.add(c5);
    }

    public ArrayList<ContaBancaria> getContas(){
        return this.contas;
    }
}