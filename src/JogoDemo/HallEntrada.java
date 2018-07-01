package JogoDemo;

import JogoDemo.Ferramentas.LockPick;
import JogoDemo.Ferramentas.Lanterna;

public class HallEntrada extends SalaJogoDemo {

	public HallEntrada() {
		super("Prisão","0");
		Lanterna lanterna = new Lanterna();
		LockPick dinamite = new LockPick();
		this.getFerramentas().put(lanterna.getDescricao(),lanterna);
		this.getFerramentas().put(dinamite.getDescricao(),dinamite);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append("\n");
		descricao.append("Seja bem-vindo ao seu novo lar.\n");
		descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("Portas: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		return false;
	}
}
