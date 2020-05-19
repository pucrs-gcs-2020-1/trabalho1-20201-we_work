public class Operador {
   private String nome_completo = "";
   private String iniciais = "";

   public Operador(String nome_completo, String iniciais) {
       this.nome_completo = nome_completo;
       this.iniciais = iniciais;
   }

   public Operador(String nome_completo) {
       this.nome_completo = nome_completo;
       for (var tmp : nome_completo.split(" ")) {
           iniciais += tmp.toCharArray()[0];
       }
   }

   public void set_nome(String nome_completo) {
       this.nome_completo = nome_completo;
   }

   public void set_iniciais(String iniciais) {
       this.iniciais = iniciais;
   }

   public String get_nome_completo() {
       return nome_completo;
   }

   public String get_iniciais() {
       return iniciais;
   }

   @Override
   public String toString() {
       return get_nome_completo() + ", " + get_iniciais();
   }
}