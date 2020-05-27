import java.lang.Math.*;

public class Operador {
    protected int idOperador;
    private String nome;
    private String iniciais;

    public Operador(int id, String nome) {
        this.idOperador = id;
        this.nome = nome;
        this.iniciais = "";

        for (String tmp : nome.split(" ")) {
            this.iniciais += tmp.toCharArray()[0];
        }
    }

    public String getNome() {
        return this.nome;
    }

    public String getIniciais() {
        return this.iniciais;
    }

    public int getIdOperador() {
        return this.idOperador;
    }

    public void transferencia(ContaBancaria d, ContaBancaria c, int v, ArrayList<Movimento> m) {
        if (d.debito(valor)) {

            c.credito(valor);

            String s = "Transferencia realizada de " + 
                d.getNome() + " para " + 
                c.getNome() + ". Operador: " +
                this.nome + ", data: " +
                m.getDataMovimentacao();

            m.add(d.addMovimento(new Movimento(this.idOperador, Math.random().nextInt(30000), s, v)));
            m.add(c.addMovimento(new Movimento(this.idOperador, Math.random().nextInt(30000), s, v)));
            
            System.out.println(s);
        }

        System.out.println("Nao foi possivel realizar a tranferencia para " + c.getNome());
    }

    @Override
    public String toString() {
        // TODO
    }
}