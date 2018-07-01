package JogoDemo.Salas;

import JogoDemo.Ferramentas.LockPick;
import JogoDemo.Mochila;
import JogoDemo.Personagem;
import JogoDemo.Sala;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;



public class PrisaoTest {

    @Test
    public void testLockPickNaCela(){
        Mochila p = new Personagem("Marlon");
        p.guardar(new LockPick());
        Sala s = new Prisao();
        s.entra(p);
        s.usa("Grampo");
        String esperado = "A cela está destrancada.";
        String obtido = s.getObjetos().get("Cela").getDescricao();

        assertEquals (esperado, obtido);

    }



}
