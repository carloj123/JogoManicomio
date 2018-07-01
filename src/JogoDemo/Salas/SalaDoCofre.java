package JogoDemo.Salas;


import ClassesBasicas.Ferramenta;
import JogoDemo.Ferramentas.Chave;
import JogoDemo.Ferramentas.LuvasDeBorracha;
import JogoDemo.Objetos.CofreEletrocutado;
import JogoDemo.Sala;

public class SalaDoCofre extends Sala {

    public SalaDoCofre() {
        super("Sala Do Cofre");
        super.getObjetos().put("Cofre Eletrocutado", new CofreEletrocutado());
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você está na ").append(super.getNome()).append(".\n");
        descricao.append("Você vê um cofre, porem BZZZ, centelhas estão saindo dele, Tome cuidado.\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }


    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = super.getMochila().usar(ferramenta);

        if (f instanceof LuvasDeBorracha) {
            super.getObjetos().get("Cofre Eletrocutado").usar(f);
            super.getFerramentas().put("Chave", new Chave());
            return true;
        }

        return false;
    }

    @Override
    public boolean pega(String nomeFerramenta) {
        boolean ok = super.pega(nomeFerramenta);
        if (ok) {
            this.getFerramentas().remove(nomeFerramenta);
            return true;
        }
        return false;
    }
}
