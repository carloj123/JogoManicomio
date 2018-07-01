package JogoDemo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Dreno;

public class Agua extends Objeto {
    public Agua(){
        super("A sala está inundada.", "A água foi drenada.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof Dreno){
            this.setAcaoOk(true);
            return f.usar();
        }

        return false;
    }
}
