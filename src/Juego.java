package src.edd;
import java.io.Serializable;
public class Juego implements Serializable{

    ArbolBinarioBusqueda<Jugador> arbol;

    public Juego(){
        arbol=new ArbolBinarioBusqueda<Jugador>();
    }

    public void addJugador(Jugador nuevo){
        arbol.add(nuevo);
    }

    public boolean buscar(Jugador j){
        return arbol.buscaElemento(j);
    }

    /**
     * Metodo que regresa al jugador si la contraseña es correcta, regresa null en otro caso
     * @param password
     * @param j
     * @return
     */
    public Jugador verificaPassword(String password, Jugador j){
        Jugador jugador=arbol.elemEnVertice(j);
        if(jugador.key.equals(password)){
            return jugador;
        }else{
            return null;
        }
    }
}
