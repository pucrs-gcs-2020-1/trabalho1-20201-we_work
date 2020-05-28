package entities;

import java.util.Random;
import java.util.ArrayList;
import java.util.Date;

public class Operador {
    private int idOperador;
    private String nome;
    private String iniciais;
    Random rd = new Random();

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

    public void transferencia(ContaBancaria d, ContaBancaria c, int v, ArrayList<Movimentacao> m) {
        if (d.debito(v)) {

            c.credito(v);

            String s = "Transferencia realizada de " +
                    d.getNome() + " para " +
                    c.getNome() + ". Operador: " +
                    this.nome + ", data: " +
                    new Date();

            m.add(d.addMovimentacao(new Movimentacao(this.idOperador, new Random().nextInt(3000), s, v)));
            m.add(c.addMovimentacao(new Movimentacao(this.idOperador, new Random().nextInt(3000), s, v)));

            System.out.println(s);
        }

        System.out.println("Nao foi possivel realizar a tranferencia para " + c.getNome());
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }
}