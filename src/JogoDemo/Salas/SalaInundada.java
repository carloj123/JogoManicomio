package JogoDemo.Salas;


import ClassesBasicas.Ferramenta;
import JogoDemo.Ferramentas.Dreno;
import JogoDemo.Ferramentas.Extintor;
import JogoDemo.Objetos.Agua;
import JogoDemo.Sala;

public class SalaInundada extends Sala {

    public SalaInundada(){
        super("Sala Inundada.");
        super.getObjetos().put("Água", new Agua());
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você está na ").append(super.getNome()).append(".\n");
        descricao.append("A sala está alagada, é impossível de passar assim.\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }


    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = super.getMochila().usar(ferramenta);

        if (f instanceof Dreno) {
            super.getObjetos().get("Água").usar(f);
            super.getFerramentas().put("Extintor", new Extintor());
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
