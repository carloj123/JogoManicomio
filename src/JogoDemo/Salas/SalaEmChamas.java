package JogoDemo.Salas;


import ClassesBasicas.Ferramenta;
import JogoDemo.Ferramentas.Extintor;
import JogoDemo.Ferramentas.LuvasDeBorracha;
import JogoDemo.Objetos.Fogo;
import JogoDemo.Sala;

public class SalaEmChamas extends Sala {

    public SalaEmChamas(){
        super("Sala em Chamas.");
        super.getObjetos().put("Fogo", new Fogo());
        }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você está na ").append(super.getNome()).append(".\n");
        descricao.append("A sala está em chamas. O fogo está alto.\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }


    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = super.getMochila().usar(ferramenta);

        if (f instanceof Extintor) {
                super.getObjetos().get("Fogo").usar(f);
                super.getFerramentas().put("Luvas de Borracha", new LuvasDeBorracha());
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
