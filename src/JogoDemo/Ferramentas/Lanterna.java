package JogoDemo.Ferramentas;

import ClassesBasicas.Ferramenta;

public class Lanterna extends Ferramenta{

    private boolean estaLigada;

    public Lanterna(){
        super("Lanterna");
        estaLigada = false;
    }

    public boolean liga(){
        if(!estaLigada) {
            estaLigada = true;
            return true;
        }

        return false;
    }

    public boolean desliga(){
        if(estaLigada){
            estaLigada = false;
            return true;
        }

        return false;
    }

    public boolean estaLigada(){
        return estaLigada;
    }

}
