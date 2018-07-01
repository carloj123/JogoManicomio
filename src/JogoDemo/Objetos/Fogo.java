package JogoDemo.Objetos;


import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Extintor;

public class Fogo extends Objeto {
    public Fogo(){
        super("O fogo está aceso.", "O fogo está apagado.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof Extintor){
            f.usar();
            this.setAcaoOk(true);
            return true;
        }

        return false;
    }
}
