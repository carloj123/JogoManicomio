package JogoDemo.Objetos;


import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import JogoDemo.Ferramentas.LockPick;

public class CofreEletrocutado extends Objeto {

    public CofreEletrocutado(){
        super("O cofre está trancado.", "O cofre está destrancado. ");

    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof LockPick){
            if(((LockPick) f).abrir()){
                this.setAcaoOk(true);
                return f.usar();
            }
        }

        return false;
    }
}
