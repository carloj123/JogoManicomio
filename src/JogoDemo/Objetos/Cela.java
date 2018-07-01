package JogoDemo.Objetos;


import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.LockPick;

public class Cela extends Objeto {
    public Cela(){
        super("A cela está trancada.", "A cela está destrancada.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof LockPick){
            if(((LockPick)f).abrir()) {
                System.out.println("Usou " + f.getDescricao());
                this.setAcaoOk(true);
                return true;
            }
        }

        return false;
    }
}
