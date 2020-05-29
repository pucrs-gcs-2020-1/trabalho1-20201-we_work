package entities;
import java.util.Date;

public class  Movimentacao {
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

  	@Override
  	public String toString() {
		return "\nData: " + this.data +
				", Inciais Operador: " + this.iniciaisOperador +
				", Id Movimentacao: " + this.idMovimentacao +
				", Descricao: " + this.descricao +
				", Valor: " + montaValor(this.valorMonetario);
  	}
}