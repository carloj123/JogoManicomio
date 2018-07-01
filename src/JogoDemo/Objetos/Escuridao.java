package JogoDemo.Objetos;


import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.Lanterna;

public class Escuridao extends Objeto {

    public Escuridao(){
        super("A sala está ecura.", "A sala está iluminada.");
    }

    @Override
    public boolean usar(Ferramenta f) {

        if(f instanceof Lanterna){
            this.setAcaoOk(true);
            return f.usar();
        }

        return false;
    }
}
