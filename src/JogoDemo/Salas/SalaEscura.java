package JogoDemo.Salas;


import ClassesBasicas.Ferramenta;
import JogoDemo.Ferramentas.Dreno;
import JogoDemo.Ferramentas.Lanterna;
import JogoDemo.Objetos.Escuridao;
import JogoDemo.Sala;

public class SalaEscura extends Sala {

    public SalaEscura(){
        super("Sala Escura.");
        super.getObjetos().put("Escuridao", new Escuridao());
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você está na ").append(super.getNome()).append(".\n");
        descricao.append("A sala está Escura como a noite mais sombria, nada pode ser visto.\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }


    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = super.getMochila().usar(ferramenta);

        if (f instanceof Lanterna) {
            super.getObjetos().get("Escuridao").usar(f);
            super.getFerramentas().put("Dreno", new Dreno());
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
