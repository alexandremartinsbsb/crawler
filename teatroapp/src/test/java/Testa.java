import java.util.List;

import teatroapp.Programacao;
import teatroapp.Fonte;

public class Testa {

  public static void main(String[] args) {

    Programacao buscaProgramacao = new Programacao();
    List<Object> buscar = buscaProgramacao.buscar(Fonte.DEBOA);

    System.out.println(buscar);

  }

}
