package JogoDemo.Objetos;


import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Chave;

public class Porta extends Objeto {
    public Porta(){
        super("A porta está trancada.", "A porta está destrancada.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof Chave){
            this.setAcaoOk(true);
            return f.usar();
        }

        return false;
    }
}
