package entities;

import java.util.Date;

public class Movimentacao {
    private int idMovimentacao;
    private Date data;
    private String iniciaisOperador;
    private String descricao;
    private int valorMonetario;

    public Movimentacao(String o, int idMovimentacao, String d, int v) {
        this.idMovimentacao = idMovimentacao;
        this.data = new Date();
        this.iniciaisOperador = o;
        this.descricao = d;
        this.valorMonetario = v;
    }

    public int getIdMovimentacao() {
        return this.idMovimentacao;
    }

    public Date getData() {
        return this.data;
    }

    public String getOperador() {
        return this.iniciaisOperador;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getValorMonetario() {
        return this.valorMonetario;
    }

    public static String montaValor(int v) {
        int real = v / 100;
        int decavos = (v % 100) / 10;
        int centavos = v % 10;

		if (v < 0) 
			return "-" + real + "," + decavos + centavos;

        return real + "," + decavos + centavos;
    }

    @Override
    public String toString() {
        return "Data: " + this.data
                + ", Inciais Operador: " + this.iniciaisOperador
                + ", Id Movimentacao: " + this.idMovimentacao
                + ", Descricao: " + this.descricao
                + ", Valor: " + montaValor(this.valorMonetario);
    }
}

5011