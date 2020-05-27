package entities;

import java.util.Date;

public class Movimentacao {
	private int idMovimentacao;
  	private Date data;
  	private int idOperador;
  	private String descricao;
  	private int valorMonetario;

  	public Movimentacao(int o, int idMovimentacao, String d, int v) {
  		this.idMovimentacao = idMovimentacao;
		this.data = new Date();
  		this.idOperador = o;
  		this.descricao = d;
  		this.valorMonetario = v;
  	}

  	public int getIdMovimentacao() {
  		return this.idMovimentacao;
  	}

	public Date getData() {
		return this.data;
	}

  	public int getOperador() {
  		return this.idOperador;
  	}

  	public String getDescricao() {
  		return this.descricao;
  	}

  	public int getValorMonetario() {
  		return this.valorMonetario;
  	}

  	@Override
  	public String toString() {
		  // TODO
		return "";
  	}
}