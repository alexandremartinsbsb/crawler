import teatroapp.Buscar;
import teatroapp.impl.ProgramacaoDeBoa;

public class Testa {

	public static void main(String[] args) {

		Buscar buscar = new Buscar(new ProgramacaoDeBoa());

		System.out.println(buscar.buscaProgramacao());

	}

}
