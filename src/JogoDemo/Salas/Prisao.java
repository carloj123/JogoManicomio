package JogoDemo.Salas;


import ClassesBasicas.Ferramenta;
import JogoDemo.Ferramentas.Lanterna;
import JogoDemo.Ferramentas.LockPick;
import JogoDemo.Objetos.Cela;
import JogoDemo.Sala;

public class Prisao extends Sala {


    public Prisao() {
        super("Prisão");
        super.getObjetos().put("Cela", new Cela());
        super.getFerramentas().put("Grampo", new LockPick());
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você está na ").append(super.getNome()).append(".\n");
        descricao.append("Está tudo úmido. Você está sozinho em uma cela.\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }


    @Override
    public boolean usa(String ferramenta) {
        //A FERRAMENTA ESPERADA É UM LOCKPICK
        Ferramenta f = super.getMochila().usar(ferramenta);

        if (f instanceof LockPick) {//SE FOR LOCKPICK
            super.getObjetos().get("Cela").usar(f);
            super.getFerramentas().put("Lanterna", new Lanterna());
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