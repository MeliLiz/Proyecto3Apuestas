package src.edd;
import java.io.Serializable;
import java.util.Iterator;
public class Juego implements Serializable{

    ArbolBinarioBusqueda<Jugador> arbol;
    Lista<Candidato> candidatos;

    public Juego(){
        arbol=new ArbolBinarioBusqueda<Jugador>();
        candidatos=new Lista<Candidato>();
        //agregar a los candidatos a la lista
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

    public void agregaCandidatos(){
        Iterator<Candidato> iterador=candidatos.iterator();
        int contador=40;
        for(int i=0;i<16;i++){
            Candidato c=new Candidato(i+1, contador+15);
            candidatos.add(c);
            contador+=15;
        }
        for(int i=0;i<candidatos.size();i++){
            candidatos.shuffle();
            for(int j=0;j<10;j++){
                Candidato actual=iterador.next();
                actual.historialPosiciones.add(j);
            }
            for(int j=10;j<candidatos.size();j++){
                Candidato actual=iterador.next();
                actual.historialPosiciones.add(j);
            }
        }
    }

}
