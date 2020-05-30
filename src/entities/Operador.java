package entities;

import interfaces.Conta;
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

    public void transferencia(Conta d, Conta c, int v) {
        if (d.debito(v)) {

            c.credito(v);

            String s = "Transferencia realizada de " +
                    d.getNome() + " para " +
                    c.getNome() + ". Operador: " +
                    this.nome + ", data: " +
                    new Date();

            d.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), s, -v));
            c.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), s, v));

            System.out.println(s);
        }

        System.out.println("Nao foi possivel realizar a tranferencia para " + c.getNome());
    }

    public void addCredito(Conta c,  String d, int v){
        c.credito(v);
        c.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), d, v));
        System.out.println("Valor "+Movimentacao.montaValor(v)+ " creditado com sucesso!!");

    }

    public boolean pagarConta(Conta c, String d, int v){
        if(c.debito(v)){
            c.addMovimentacao(new Movimentacao(this.iniciais, new Random().nextInt(3000), d, -v));
            System.out.println("Valor "+Movimentacao.montaValor(v)+ " debitado com sucesso!!");
            return true;
        }
        System.out.println("Valor insuficiênte para pagar esta conta" );
        return false;
        
    }

    @Override
    public String toString() {
        return "\nNome: " + getNome() + ", ID: " + getIdOperador();
    }
}