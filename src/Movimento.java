
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

  // public static void main(String[] args) throws ParseException {
  //   Movimento m = new Movimento("12/01/2020", "AMN", "0021", "Fatura Nubank", -245.78);
  //   Movimento m1 = new Movimento("12/01/2020", "AMN", "0021", "Pagamento Luz", -245.78);
  //   Movimento m2 = new Movimento("12/01/2020", "AMN", "0021", "Prestação casa", -500.78);
  //   Movimento m3 = new Movimento("12/01/2020", "AMN", "0021", "Pagamento salário", 2550.67);
  //   Movimento m4 = new Movimento("12/01/2020", "AMN", "0021", "Condomínio", -656.78);
  //   Movimento m5 = new Movimento("12/01/2020", "AMN", "0021", "Estacionamento", -32.78);
  //   Movimento m6 = new Movimento("12/01/2020", "AMN", "0021", "Alimentação", -1200.78);

  //   ArrayList<Movimento> mov = new ArrayList<>();
  //   mov.add(m);
  //   mov.add(m1);
  //   mov.add(m2);
  //   mov.add(m3);
  //   mov.add(m4);
  //   mov.add(m5);
  //   mov.add(m6);
  //   double posi = 0.0;
  //   double negativo = 0.0;
  //   for (Movimento movimento : mov) {
  //     System.out.println(movimento.toString());
  //     if (movimento.getValor() < 0) {
  //       negativo += movimento.getValor();
  //     } else {
  //       posi += movimento.getValor();
  //     }

  //   }
   
  //   System.out.printf("\t\t\t\t\t\t\tSaldo atual: %.2f",  (posi + negativo));

  // }
}