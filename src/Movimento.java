package interfaces;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Movimento {
  	private Date data;
  	private String operador;
  	private String nroDoc;
  	private String descricao;
  	private double valor;
  	private SimpleDateFormat sdf;

  	public Movimento(String _date, String _operador, String numDoc, String descr, double _valor) throws ParseException {
  		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
  		this.data = new Date();

  		try {
  			data = sdf.parse(_date);
  		} catch (ParseException e) {
  			e.printStackTrace();
  			System.out.println("Formato da data errado: [use: dd/mm/yyyy]");
  		}

  		this.operador = _operador;
  		this.nroDoc = numDoc;
  		this.descricao = descr;
  		this.valor = _valor;
  	}

	public String getData() {
		return sdf.format(data);
	}

  	public void setData(String _data) {
		try {
			data = sdf.parse(_data);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Formato da data errado: [use: dd/mm/yyyy]");
		}
  	}

  	public String getOperador() {
  		return operador;
  	}

  	public void setOperador(String operador) {
  		this.operador = operador;
  	}

  	public String getNroDoc() {
  		return nroDoc;
  	}

  	public void setNroDoc(String nroDoc) {
  		this.nroDoc = nroDoc;
  	}

  	public String getDescricao() {
  		return descricao;
  	}

  	public void setDescricao(String descricao) {
  		this.descricao = descricao;
  	}

  	public double getValor() {
  		return valor;
  	}

  	public void setValor(double valor) {
  		this.valor = valor;
  	}

  	public SimpleDateFormat getSdf() {
  		return sdf;
  	}

  	public void setSdf(SimpleDateFormat sdf) {
  		this.sdf = sdf;
  	}

  	@Override
  	public String toString() {
  		String msg = "";

  		msg = msg + getData() + " | " + getOperador() + " | " + getNroDoc() + " | " + getDescricao() + " \t\t\t"
  		+ getValor() + " | ";

  		return msg;
  	}
}