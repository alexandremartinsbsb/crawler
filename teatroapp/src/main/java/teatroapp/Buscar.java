package teatroapp;

import java.util.List;

public class Buscar {

	private Programacao programacao;
	
	public Buscar(Programacao programacao) {
		this.programacao = programacao;
	}

	public List<Object> buscaProgramacao() {
		return this.programacao.buscar();
	}
}
