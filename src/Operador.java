public class Operador {
    private String nomeCompleto = "";
    private String iniciais = "";
    protected int id;

    public Operador(int id, String nomeCompleto) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        for (var tmp : nomeCompleto.split(" ")) {
            this.iniciais += tmp.toCharArray()[0];
        }
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public String getIniciais() {
        return this.iniciais;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
       return  "ID: " + getId() +
               ", Nome Completo: " + getNomeCompleto() +
               ", Iniciais: " + getIniciais();
    }
}