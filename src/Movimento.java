import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Movimento {
  private Date data;

  public Movimento() {

  }

  public static void main(String[] args) throws ParseException {
    Date data = new Date();
    System.out.println("Data Agora: " + data);

    Calendar c = Calendar.getInstance();
    data = c.getTime();
    DateFormat f = DateFormat.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("Data formatada: " + sdf.format(data));

    try {
      Date data2 = new Date();
      data2 = f.parse("12/03/1995");
      System.out.println(sdf.format(data2));
    } catch (ParseException e) {
      // TODO: handle exception
      e.printStackTrace();
    }

  }
}