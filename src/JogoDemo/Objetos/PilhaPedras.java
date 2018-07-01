package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Picareta;

public class PilhaPedras extends Objeto {
	public PilhaPedras() {
		super("Pilha de pedras","Pedras espalhadas");
	}

	@Override
	public boolean usar(Ferramenta f) {
		if (f instanceof Picareta) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
}
